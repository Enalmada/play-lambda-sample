name := """play-lambda-sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.amazonaws" % "aws-lambda-java-events" % "1.1.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Assembly
assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".types" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".json" => MergeStrategy.discard
  case "application.conf" => MergeStrategy.concat
  case "Unwanted.Txt" => MergeStrategy.discard
  case x => (assemblyMergeStrategy in assembly).value(x)
}

// If you need to exclude some unnecessary jars, this is one way to do it.
// Probably not the best....see assembly plugin for potentially better ways to do it.
/*
assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter { f =>
    f.data.getName.startsWith("bone") ||
      f.data.getName.startsWith("ehcache") ||
      f.data.getName.startsWith("xerces") ||
      f.data.getName.startsWith("play-cache") ||
      f.data.getName.startsWith("HikariCP") ||
      f.data.getName.startsWith("joda-time") ||
      f.data.getName.startsWith("jackson") ||
      f.data.getName.startsWith("twirl") ||
      f.data.getName.startsWith("play-jdbc") ||
      f.data.getName.startsWith("h2")
  }
}
*/