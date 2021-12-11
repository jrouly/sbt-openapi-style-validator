name := "sbt-openapi-style-validator"
organization := "net.rouly"
description := "Supports functionality from openapi-style-validator as part of an sbt build."

scriptedBufferLog := false
scriptedLaunchOpts ++= Seq("-Xmx1024M", "-server", "-Dplugin.version=" + version.value)

Global / onChangedBuildSource := ReloadOnSourceChanges

enablePlugins(SbtPlugin)

libraryDependencies ++= Seq(
  "org.openapitools.openapistylevalidator" % "openapi-style-validator-lib" % "1.7",
  "io.swagger.parser.v3" % "swagger-parser" % "2.0.24",
  "org.openapitools.empoa" % "empoa-swagger-core" % "2.0.0",
  "com.typesafe" % "config" % "1.4.1"
)

crossScalaVersions := Seq("2.10.7", "2.12.10")

pluginCrossBuild / sbtVersion := {
  scalaBinaryVersion.value match {
    case "2.10" => "0.13.18"
    case "2.12" => "1.1.6" // https://github.com/sbt/sbt/issues/5049
  }
}
