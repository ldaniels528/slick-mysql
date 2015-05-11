import sbt.Keys._
import sbt._
import sbtassembly.Plugin.AssemblyKeys._
import sbtassembly.Plugin._

name := "slick-mysql"

organization := "com.ldaniels528"

version := "0.1"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-target:jvm-1.7", "-unchecked",
  "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint")

javacOptions ++= Seq("-Xlint:deprecation", "-Xlint:unchecked", "-source", "1.7", "-target", "1.7", "-g:vars")

assemblySettings

mainClass in assembly := Some("com.ldaniels528.slick.mysql.MySQLtoSlickGenerator")

test in assembly := {}

jarName in assembly := "slick-mysql_" + version.value + ".bin.jar"

mergeStrategy in assembly := {
  case PathList("stax", "stax-api", xs@_*) => MergeStrategy.first
  case PathList("log4j-over-slf4j", xs@_*) => MergeStrategy.discard
  case PathList("META-INF", "MANIFEST.MF", xs@_*) => MergeStrategy.discard
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (mergeStrategy in assembly).value
    oldStrategy(x)
}

// github/ldaniels528 Dependencies
libraryDependencies ++= Seq(
  "com.ldaniels528" %% "commons-helpers" % "0.1.0"
)

// General Dependencies
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "log4j" % "log4j" % "1.2.17",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.slf4j" % "slf4j-log4j12" % "1.7.7"
)

// Testing Dependencies
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.2" % "test"
)
