package org.openapitools.openapistylevalidator.sbt.plugin

import io.swagger.v3.parser.OpenAPIV3Parser
import org.openapitools.empoa.swagger.core.internal.SwAdapter
import org.openapitools.openapistylevalidator.OpenApiSpecStyleValidator
import org.openapitools.openapistylevalidator.ValidatorParameters.NamingConvention
import org.openapitools.openapistylevalidator.sbt.plugin.tasks.OpenApiStyleValidatorParametersTask
import org.openapitools.openapistylevalidator.styleerror.StyleError
import sbt._
import sbt.plugins.JvmPlugin

import java.util.function.Consumer
import scala.collection.mutable.ListBuffer

object OpenApiStylePlugin
  extends sbt.AutoPlugin
  with OpenApiStyleKeys
  with OpenApiStyleValidatorParametersTask {

  override def requires: JvmPlugin.type = sbt.plugins.JvmPlugin

  override def trigger: sbt.PluginTrigger = noTrigger

  object autoImport extends OpenApiStyleKeys

  override lazy val projectSettings: Seq[Def.Setting[_]] = pluginSettings ++ defaultSettings

  private lazy val pluginSettings: Seq[Def.Setting[_]] = Seq(
    openApiStyleSpec := sys.error("openApiStyleFile is undefined. Did you forget to set it?"),
    openApiStyleValidatorParameters := openApiStyleValidatorParametersTask().value,
    openApiStyleValidationResult := {
      val parameters = openApiStyleValidatorParameters.value

      val swaggerOpenApiParser = new OpenAPIV3Parser()
      val swaggerOpenApi = swaggerOpenApiParser.read(openApiStyleSpec.value.getAbsolutePath)

      val openApi = SwAdapter.toOpenAPI(swaggerOpenApi)
      val validator = new OpenApiSpecStyleValidator(openApi)

      val errors = ListBuffer.empty[String]
      validator.validate(parameters).forEach(new Consumer[StyleError] {
        override def accept(error: StyleError): Unit = errors += error.toString
      })
      errors.toList
    },
    openApiStyleValidate := {
      val errors = openApiStyleValidationResult.value
      if (errors.nonEmpty) {
        val report = errors.mkString("\n")
        sys.error("OpenAPI specification style validation failed.\n" + report)
      } else ()
    }
  )

  private lazy val defaultSettings: Seq[Def.Setting[_]] = Seq(
    openApiStyleValidateInfoLicense := None,
    openApiStyleValidateInfoDescription := None,
    openApiStyleValidateInfoContact := None,

    openApiStyleValidateOperationId := None,
    openApiStyleValidateOperationDescription := None,
    openApiStyleValidateOperationTag := None,
    openApiStyleValidateOperationSummary := None,

    openApiStyleValidateModelPropertiesExample := None,

    openApiStyleValidateNaming := None,

    openApiStyleIgnoreHeaderXNaming := None,

    openApiStylePathNamingConvention := None,
    openApiStyleParameterNamingConvention := None,
    openApiStyleHeaderNamingConvention := None,
    openApiStylePropertyNamingConvention := None
  )
}
