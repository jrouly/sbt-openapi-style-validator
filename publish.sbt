import com.jsuereth.sbtpgp.PgpKeys.publishSigned
import sbt._

organizationHomepage := Some(url("https://openapi-generator.tech/"))
homepage := Some(url("https://openapi-generator.tech/"))
licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/jrouly/sbt-openapi-style-validator"),
    "scm:git@github.com:jrouly/sbt-openapi-style-validator.git"
  )
)

developers := List(
  Developer(
    id = "jrouly",
    name = "Michel Rouly",
    email = "michel@rouly.net",
    url = url("https://michel.rouly.net")
  )
)

credentials += Credentials(
  realm = "Sonatype Nexus Repository Manager",
  host = "s01.oss.sonatype.org",
  userName = sys.env.getOrElse("SONATYPE_USER", "username"),
  passwd = sys.env.getOrElse("SONATYPE_PASS", "password")
)

pomIncludeRepository := { _ => false }
pgpSigningKey := Some("0xFA8B833314500A89")

publishMavenStyle := true

publishTo := Some {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) "snapshots" at nexus + "content/repositories/snapshots"
  else "releases" at nexus + "service/local/staging/deploy/maven2"
}
