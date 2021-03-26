package org.openapitools.openapistylevalidator.sbt.plugin.tasks

import io.swagger.v3.parser.OpenAPIV3Parser
import org.openapitools.empoa.swagger.core.internal.SwAdapter
import org.openapitools.openapistylevalidator.OpenApiSpecStyleValidator
import org.openapitools.openapistylevalidator.sbt.plugin.OpenApiStyleKeys
import org.openapitools.openapistylevalidator.styleerror.StyleError
import sbt.{Def, Task}

import java.util.function.Consumer
import scala.collection.mutable.ListBuffer

trait OpenApiStyleValidationResultTask extends OpenApiStyleKeys {

  def openApiStyleValidationResultTask(): Def.Initialize[Task[List[String]]] = Def.task {
    val parameters = openApiStyleValidatorParameters.value

    val swaggerOpenApiParser = new OpenAPIV3Parser()
    val swaggerOpenApi = swaggerOpenApiParser.read(openApiStyleSpec.value.getAbsolutePath)

    val openApi = SwAdapter.toOpenAPI(swaggerOpenApi)
    val validator = new OpenApiSpecStyleValidator(openApi)

    val errors = ListBuffer.empty[String]
    validator
      .validate(parameters)
      .forEach(new Consumer[StyleError] {
        override def accept(error: StyleError): Unit = errors += error.toString
      })
    errors.toList
  }

}
