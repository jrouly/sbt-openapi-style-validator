package org.openapitools.openapistylevalidator.sbt.plugin.config

import com.typesafe.config.Config

private[plugin] object ConfigExtension {

  implicit class RichConfig(val underlying: Config) extends AnyVal {
    def getOptionalBoolean(path: String): Option[Boolean] = {
      if (underlying.hasPath(path)) {
        Some(underlying.getBoolean(path))
      } else {
        None
      }
    }

    def getOptionalString(path: String): Option[String] = {
      if (underlying.hasPath(path)) {
        Some(underlying.getString(path))
      } else {
        None
      }
    }
  }

}
