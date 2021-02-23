package org.openapitools.openapistylevalidator.sbt.plugin.tasks

import org.openapitools.openapistylevalidator.sbt.plugin.OpenApiStyleKeys
import sbt.Keys._
import sbt.{Def, Task}

trait OpenApiStyleValidateTask extends OpenApiStyleKeys {

  def openApiStyleValidateTask(): Def.Initialize[Task[Unit]] = Def.task {
    val log = streams.value.log
    val errors = openApiStyleValidationResult.value

    if (errors.nonEmpty) {
      val report = errors.mkString("\n")
      sys.error("OpenAPI specification style validation failed.\n" + report)
    } else log.info("OpenAPI specification style validation passed.")
  }

}
