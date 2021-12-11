package org.openapitools.openapistylevalidator.sbt.plugin.tasks

import com.typesafe.config.ConfigFactory
import org.openapitools.openapistylevalidator.ValidatorParameters
import org.openapitools.openapistylevalidator.ValidatorParameters.NamingConvention
import org.openapitools.openapistylevalidator.sbt.plugin.OpenApiStyleKeys
import org.openapitools.openapistylevalidator.sbt.plugin.config.ConfigExtension._
import sbt._

trait OpenApiStyleValidatorParametersTask extends OpenApiStyleKeys {

  def openApiStyleValidatorParametersTask(): Def.Initialize[ValidatorParameters] = Def.setting {
    val parameters = new ValidatorParameters()

    openApiStyleConfig.value.foreach { file =>
      val config = ConfigFactory.parseFile(file)

      config
        .getOptionalBoolean("validateInfoLicense")
        .foreach(parameters.setValidateInfoLicense)

      config
        .getOptionalBoolean("validateInfoDescription")
        .foreach(parameters.setValidateInfoDescription)

      config
        .getOptionalBoolean("validateInfoContact")
        .foreach(parameters.setValidateInfoContact)

      config
        .getOptionalBoolean("validateOperationId")
        .foreach(parameters.setValidateOperationOperationId)

      config
        .getOptionalBoolean("validateOperationDescription")
        .foreach(parameters.setValidateOperationDescription)

      config
        .getOptionalBoolean("validateOperationTag")
        .foreach(parameters.setValidateOperationTag)

      config
        .getOptionalBoolean("validateOperationSummary")
        .foreach(parameters.setValidateOperationSummary)

      config
        .getOptionalBoolean("validateModelPropertiesExample")
        .foreach(parameters.setValidateModelPropertiesExample)

      config
        .getOptionalBoolean("validateModelPropertiesDescription")
        .foreach(parameters.setValidateModelPropertiesDescription)

      config
        .getOptionalBoolean("validateModelRequiredProperties")
        .foreach(parameters.setValidateModelRequiredProperties)

      config
        .getOptionalBoolean("validateNaming")
        .foreach(parameters.setValidateNaming)

      config
        .getOptionalBoolean("ignoreHeaderXNaming")
        .foreach(parameters.setIgnoreHeaderXNaming)

      config
        .getOptionalString("pathNamingConvention")
        .map(NamingConvention.valueOf)
        .foreach(parameters.setPathNamingConvention)

      config
        .getOptionalString("parameterNamingConvention")
        .map(NamingConvention.valueOf)
        .foreach(parameters.setParameterNamingConvention)

      config
        .getOptionalString("headerNamingConvention")
        .map(NamingConvention.valueOf)
        .foreach(parameters.setHeaderNamingConvention)

      config
        .getOptionalString("propertyNamingConvention")
        .map(NamingConvention.valueOf)
        .foreach(parameters.setPropertyNamingConvention)
    }

    openApiStyleValidateInfoLicense.value.foreach(parameters.setValidateInfoLicense)
    openApiStyleValidateInfoDescription.value.foreach(parameters.setValidateInfoDescription)
    openApiStyleValidateInfoContact.value.foreach(parameters.setValidateInfoContact)

    openApiStyleValidateOperationId.value.foreach(parameters.setValidateOperationOperationId)
    openApiStyleValidateOperationDescription.value.foreach(
      parameters.setValidateOperationDescription
    )
    openApiStyleValidateOperationTag.value.foreach(parameters.setValidateOperationTag)
    openApiStyleValidateOperationSummary.value.foreach(parameters.setValidateOperationSummary)

    openApiStyleValidateModelPropertiesExample.value.foreach(
      parameters.setValidateModelPropertiesExample
    )
    openApiStyleValidateModelPropertiesDescription.value.foreach(
      parameters.setValidateModelPropertiesDescription
    )
    openApiStyleValidateModelRequiredProperties.value.foreach(
      parameters.setValidateModelRequiredProperties
    )

    openApiStyleValidateNaming.value.foreach(parameters.setValidateNaming)

    openApiStyleIgnoreHeaderXNaming.value.foreach(parameters.setIgnoreHeaderXNaming)

    openApiStylePathNamingConvention.value.foreach(parameters.setPathNamingConvention)
    openApiStyleParameterNamingConvention.value.foreach(parameters.setParameterNamingConvention)
    openApiStyleHeaderNamingConvention.value.foreach(parameters.setHeaderNamingConvention)
    openApiStylePropertyNamingConvention.value.foreach(parameters.setParameterNamingConvention)

    parameters
  }

}
