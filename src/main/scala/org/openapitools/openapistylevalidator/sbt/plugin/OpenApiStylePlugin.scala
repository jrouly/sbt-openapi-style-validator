package org.openapitools.openapistylevalidator.sbt.plugin

import org.openapitools.openapistylevalidator.ValidatorParameters
import org.openapitools.openapistylevalidator.sbt.plugin.tasks._
import sbt._
import sbt.plugins.JvmPlugin

object OpenApiStylePlugin
  extends sbt.AutoPlugin
  with OpenApiStyleKeys
  with OpenApiStyleValidatorParametersTask
  with OpenApiStyleValidationResultTask
  with OpenApiStyleValidateTask {

  override def requires: JvmPlugin.type = sbt.plugins.JvmPlugin

  override def trigger: sbt.PluginTrigger = noTrigger

  object autoImport extends OpenApiStyleKeys {

    // Aliases for convenience.
    object NamingConvention {
      import ValidatorParameters.{NamingConvention => ValidatorNamingConvention}

      val UnderscoreCase = ValidatorNamingConvention.UnderscoreCase
      val UnderscoreUpperCase = ValidatorNamingConvention.UnderscoreUpperCase
      val CamelCase = ValidatorNamingConvention.CamelCase
      val HyphenCase = ValidatorNamingConvention.HyphenCase
    }

  }

  override lazy val projectSettings: Seq[Def.Setting[_]] = pluginSettings ++ defaultSettings

  private lazy val pluginSettings: Seq[Def.Setting[_]] = Seq(
    openApiStyleSpec := sys.error("openApiStyleFile is undefined. Did you forget to set it?"),
    openApiStyleConfig := None,
    openApiStyleValidationResult := openApiStyleValidationResultTask().value,
    openApiStyleValidate := openApiStyleValidateTask().value,
    openApiStyleValidatorParameters := openApiStyleValidatorParametersTask().value
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
