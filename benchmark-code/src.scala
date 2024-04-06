//> using scala 3.4.0
//> using dep org.scala-lang.modules::scala-xml::2.2.0+52-1bbfb905+20240328-1127-SNAPSHOT
//> using dep org.json4s::json4s-ast::4.0.7
//> using dep org.json4s::json4s-native-core::4.0.7
//> using dep org.json4s::json4s-xml::4.0.7

// //> using dep org.json4s::json4s-core::4.0.7
// //> using dep org.json4s::json4s-ext::4.0.7

import scala.collection.mutable
import scala.jdk.CollectionConverters.*
import scala.io.Source
import scala.util.Random
import scala.xml.parsing.ConstructingParser

import java.io.File
import java.nio.file.*

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.Xml.toJson

object Dataset {
  def loadEntryElem(file: File): xml.Node = {
    val res = util.Using(Source.fromFile(file)) { src =>
      ConstructingParser.fromSource(src, false).document()
    }
    res.get.docElem
  }

  val reloadedEntries =
    List(
      "row-222e~2jxf_exna.xml",
      "row-222i.7cxe-7frd.xml",
      "row-222m-ka8r-b4xc.xml",
      "row-222p-effy~bpe9.xml",
      "row-222p.pe96.jcxs.xml",
      "row-222p.tkd4_hipu.xml",
      "row-222x-kpi2-m7ry.xml",
      "row-2235.zi4c_8jyx.xml",
      "row-223a_iduk.2ra9.xml",
      "row-223e.h733~xe32.xml",
    ).map("./dataset/selected-rows/" + _)
}

@main
def main(numIter: Int) = {
  println(s"# of iterations: $numIter")

  def loadReloadedEntryElems() =
    Dataset.reloadedEntries.map { s =>
      // the enclosure should be here
      System.err.print("\nEnclosure+\n")
      val res = Dataset.loadEntryElem(Paths.get(s).toFile)
      System.err.print("\nEnclosure-\n")
      res
    }

  for i <- 1.to(numIter) do {
    val startTime = System.nanoTime()

    val xmls = loadReloadedEntryElems()
    println( compact(render(JArray(xmls.map(toJson)))) )

    val elapsed = (System.nanoTime() - startTime)
    System.err.print(s"\nResponse time: $elapsed\n")
  }
}
