resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots")
)
sys.props.get("plugin.version") match {
  case Some(x) =>
    addSbtPlugin("net.rouly" % "sbt-openapi-style-validator" % x)
  case _ =>
    throw new Exception("The system property 'plugin.version' is not defined.")
}
