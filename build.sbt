def n(s: String) = s + "_native0.4_3"

lazy val commonSettings = Seq(
  scalaVersion := "3.4.0",

  // set to Debug for compilation details (Info is default)
  logLevel := Level.Info,

  libraryDependencies ++= Seq(
    // "org.scala-lang.modules" %%% "scala-xml" % "2.2.0+52-1bbfb905+20240328-1127-SNAPSHOT",
    // "org.json4s" %%% "json4s-ast" % "4.0.7",
    // "org.json4s" %%% "json4s-native-core" % "4.0.7",
    // "org.json4s" %%% "json4s-xml" % "4.0.7",

    "org.scala-lang.modules" % n("scala-xml") % "2.2.0+52-1bbfb905+20240328-1127-SNAPSHOT",
    "org.json4s" % n("json4s-ast") % "4.0.7",
    "org.json4s" % n("json4s-native-core") % "4.0.7",
    "org.json4s" % n("json4s-xml") % "4.0.7",
  ),
)

import scala.scalanative.build._

lazy val benchmark =
  project.in(file("benchmark-code"))
    .enablePlugins(ScalaNativePlugin)
    .settings(
      commonSettings,
      nativeConfig ~= { c =>
        c.withLTO(LTO.none) // thin
        // c.withLTO(LTO.thin) // thin
          .withMode(Mode.debug) // releaseFast
          // .withMode(Mode.release) // releaseFast
          .withGC(GC.immix) // commix
          .withCompileOptions(c.compileOptions ++ Seq("-DDEBUG_PRINT"))
      }
    )

lazy val optimized =
  project.in(file("optimized"))
    .enablePlugins(ScalaNativePlugin)
    .settings(
      commonSettings,
      nativeConfig ~= { c =>
        // c.withLTO(LTO.none) // thin
        c.withLTO(LTO.thin) // thin
          // .withMode(Mode.debug) // releaseFast
          .withMode(Mode.release) // releaseFast
          .withGC(GC.immix) // commix
          .withCompileOptions(c.compileOptions ++ Seq("-DDEBUG_PRINT"))
      }
    )
