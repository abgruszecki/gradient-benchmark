//> using scala 3.4.0
//> using dep org.scala-lang.modules::scala-xml::2.2.0+52-1bbfb905+20240328-1127-SNAPSHOT
//> using dep org.json4s::json4s-ast::4.0.7
//> using dep org.json4s::json4s-native-core::4.0.7
//> using dep org.json4s::json4s-xml::4.0.7

// //> using dep org.json4s::json4s-core::4.0.7
// //> using dep org.json4s::json4s-ext::4.0.7

// class Foo {
//   override def toString() = "."
// }

// class Bar {
//   override def toString() = ","
// }

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
  class LRUCache[K, V](private val maxEntries: Int)
    extends java.util.LinkedHashMap[K, V](100, .75f, true) {

    override def removeEldestEntry(eldest: java.util.Map.Entry[K, V]): Boolean
      = this.size > this.maxEntries
  }

  // val cache: mutable.Map[File, xml.Node] = LRUCache(1000).asScala

  // val files: Seq[File] = {
  //   val datasetDir = Paths.get("./dataset/rows").toFile
  //   assert(datasetDir.exists())
  //   datasetDir.listFiles().toSeq
  // }

  // val size = this.files.size

  def loadEntryElem(file: File): xml.Node = {
    val res = util.Using(Source.fromFile(file)) { src =>
      ConstructingParser.fromSource(src, false).document()
    }
    res.get.docElem
  }

  // def randomEntryFile(): File = {
  //   this.files(Random.nextInt(this.size))
  // }

  // def randomEntryElem(): xml.Node = {
  //   val file = this.randomEntryFile()
  //   cache.getOrElseUpdate(file, { this.loadEntryElem(file) })
  // }

  val preloadedEntries =
    List(
      "row-222e~2jxf_exna.xml",
      "row-222i.7cxe-7frd.xml",
      "row-222m-ka8r-b4xc.xml",
      "row-222p-effy~bpe9.xml",
      "row-222p.pe96.jcxs.xml",
    ).map("./dataset/selected-rows/" + _)

  val reloadedEntries =
    List(
      "row-222p.tkd4_hipu.xml",
      "row-222x-kpi2-m7ry.xml",
      "row-2235.zi4c_8jyx.xml",
      "row-223a_iduk.2ra9.xml",
      "row-223e.h733~xe32.xml",
    ).map("./dataset/selected-rows/" + _)

  val preloadedEntryElems = preloadedEntries.map(s => loadEntryElem(Paths.get(s).toFile))
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

    val xmls =
      Dataset.preloadedEntryElems ++:
        loadReloadedEntryElems()
    println( compact(render(JArray(xmls.map(toJson)))) )

    val elapsed = (System.nanoTime() - startTime)
    System.err.print(s"\nResponse time: $elapsed\n")
  }

  var arr: Array[Object] = null
  var iter = 0
  // while iter < numIter do {
  //   arr = Array.fill(10000) {
  //     // if util.Random.nextBoolean() then Foo() else Bar()
  //     // Foo()
  //     new Object() {}
  //   }
  //   // print(arr(util.Random.nextInt(1000)).toString)
  //   // print(arr(0).toString)

  //   // if iter % 100 == 0 then {
  //   //   import scala.io.Source
  //   //   import scala.xml.parsing.ConstructingParser
  //   //   // import scala.xml.XML
  //   //   // val xml = XML.loadFile("input.xml")

  //   //   print('\n')

  //   //   val xml = {
  //   //     val src = Source.fromFile("./input.xml")
  //   //     // def src() = Source.fromString("<foo/>")
  //   //     val xmlp = ConstructingParser.fromSource(src, false)
  //   //     // locally {
  //   //     //   val ch = xmlp.ch
  //   //     //   println(s"Char is: `$ch` (${ch.toInt})")
  //   //     // }
  //   //     // locally {
  //   //     //   val ch = src().next()
  //   //     //   println(s"Test char is: `$ch` (${ch.toInt})")

  //   //     // }
  //   //     xmlp.document()
  //   //   }

  //   //   println(xml.toString)

  //   //   // Check XML->JSON conversion
  //   //   locally {
  //   //     import org.json4s._
  //   //     import org.json4s.native.JsonMethods._
  //   //     import org.json4s.Xml.toJson
  //   //     println(compact(render(toJson(xml.docElem))))
  //   //   }
  //   // }

  //   // Check free memory
  //   // if iter % 100 == 0 then {
  //   //   val rt = Runtime.getRuntime
  //   //   print('\n')
  //   //   println("Free memory: " + rt.freeMemory)
  //   // }

  //   Thread.sleep(20)
  //   iter += 1
  // }
}
