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

libraryDependencies ++= Seq(
  "org.openapitools.openapistylevalidator" % "openapi-style-validator-lib" % "1.5",
  "io.swagger.parser.v3" % "swagger-parser" % "2.0.24",
  "org.openapitools.empoa" % "empoa-swagger-core" % "2.0.0"
)

publishMavenStyle := false

credentials += Credentials(
  "Artifactory Realm",
  "jrouly.jfrog.io",
  sys.env.getOrElse("ARTIFACTORY_USER", "user"),
  sys.env.getOrElse("ARTIFACTORY_PASS", "pass")
)

publishTo := {
  def resolver(host: String, repo: String) =
    Resolver.url(repo, url(s"https://$host/artifactory/$repo"))(Resolver.ivyStylePatterns)
  if (isSnapshot.value) Some(resolver("jrouly.jfrog.io", "ivy-snapshot-local"))
  else Some(resolver("jrouly.jfrog.io", "ivy-release-local"))
}

scriptedBufferLog := false
scriptedLaunchOpts := {
  scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-server", "-Dplugin.version=" + version.value)
}

Global / onChangedBuildSource := ReloadOnSourceChanges
