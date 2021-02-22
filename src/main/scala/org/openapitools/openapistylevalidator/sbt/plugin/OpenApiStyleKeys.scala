package org.openapitools.openapistylevalidator.sbt.plugin

import org.openapitools.openapistylevalidator.ValidatorParameters
import org.openapitools.openapistylevalidator.ValidatorParameters.NamingConvention
import sbt._

trait OpenApiStyleKeys {

  final val openApiStyleSpec = taskKey[File]("OpenAPI specification file.")
  final val openApiStyleValidate = taskKey[Unit]("Validates OpenAPI specification file: success or failure.")
  final val openApiStyleValidationResult = taskKey[Seq[String]]("Validates OpenAPI specification file: evaluates to a list of detailed error messages.")

  final val openApiStyleValidatorParameters = settingKey[ValidatorParameters]("OpenAPI Style Validator parameters.")

  final val openApiStyleValidateInfoLicense = settingKey[Option[Boolean]]("Ensures that there is a license section in the info section.")
  final val openApiStyleValidateInfoDescription = settingKey[Option[Boolean]]("Ensures that there is a description attribute in the info section.")
  final val openApiStyleValidateInfoContact = settingKey[Option[Boolean]]("Ensures that there is a contact section in the info section.")

  final val openApiStyleValidateOperationId = settingKey[Option[Boolean]]("Ensures that there is an operation id for each operation.")
  final val openApiStyleValidateOperationDescription = settingKey[Option[Boolean]]("Ensures that there is a description for each operation.")
  final val openApiStyleValidateOperationTag = settingKey[Option[Boolean]]("Ensures that there is a tag for each operation.")
  final val openApiStyleValidateOperationSummary = settingKey[Option[Boolean]]("Ensures that there is a summary for each operation.")

  final val openApiStyleValidateModelPropertiesExample = settingKey[Option[Boolean]]("Ensures that the properties of the Schemas have an example value defined.")

  final val openApiStyleValidateNaming = settingKey[Option[Boolean]]("Ensures the names follow a given naming convention.")

  final val openApiStyleIgnoreHeaderXNaming = settingKey[Option[Boolean]]("Exclude from validation header parameters starting with x-.")

  final val openApiStylePathNamingConvention = settingKey[Option[NamingConvention]]("Naming convention for paths.")
  final val openApiStyleParameterNamingConvention = settingKey[Option[NamingConvention]]("Naming convention for parameters.")
  final val openApiStyleHeaderNamingConvention = settingKey[Option[NamingConvention]]("Naming convention for headers.")
  final val openApiStylePropertyNamingConvention = settingKey[Option[NamingConvention]]("Naming convention for properties.")

}
