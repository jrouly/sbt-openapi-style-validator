name := "sbt-openapi-style-validator"
organization := "org.openapitools.openapistylevalidator"
description := "Supports functionality from openapi-style-validator as part of an sbt build."

licenses += ("The Apache Software License, Version 2.0", url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/jrouly/sbt-openapi-style-validator"))

developers += Developer(
  id = "jrouly",
  name = "Jean Michel Rouly",
  email = "michel@rouly.net",
  url = url("https://github.com/jrouly")
)

scmInfo := Some(
  ScmInfo(
    browseUrl = url("https://github.com/jrouly/sbt-openapi-style-validator"),
    connection = "scm:git:git://github.com/jrouly/sbt-openapi-style-validator.git",
    devConnection = "scm:git:ssh://git@github.com:jrouly/sbt-openapi-style-validator.git"
  )
)

enablePlugins(SbtPlugin)
sbtPlugin := true
crossSbtVersions := List("0.13.18", "1.4.6")

libraryDependencies += "org.openapitools.openapistylevalidator" % "openapi-style-validator-lib" % "1.5"

publishMavenStyle := false

bintrayRepository := "sbt-plugins"
bintrayOrganization := Option("jrouly")
bintrayPackageLabels := Seq("sbt", "plugin", "oas", "openapi", "openapi-style-validator")
bintrayVcsUrl := Some("git@github.com:jrouly/sbt-openapi-style-validator.git")

scriptedBufferLog := false
scriptedLaunchOpts := {
  scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-server", "-Dplugin.version=" + version.value)
}
