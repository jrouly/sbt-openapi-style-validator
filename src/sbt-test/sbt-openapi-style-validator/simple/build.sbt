lazy val noop = project

lazy val config = project
  .enablePlugins(OpenApiStylePlugin)
  .settings(
    openApiStyleSpec := file("petstore.yaml"),
    openApiStyleConfig := Some(file("openapi-style-validator.conf"))
  )
  .settings(
    TaskKey[Unit]("check") := {
      val errors = openApiStyleValidationResult.value
      if (errors.nonEmpty) sys.error("Style validation errors found.")
      ()
    }
  )

lazy val problematic = project
  .enablePlugins(OpenApiStylePlugin)
  .settings(openApiStyleSpec := file("petstore.yaml"))
  .settings(
    TaskKey[Unit]("check") := {
      val errors = openApiStyleValidationResult.value
      if (errors.isEmpty) sys.error("No style validation errors found.")
      ()
    }
  )

lazy val ok = project
  .enablePlugins(OpenApiStylePlugin)
  .settings(openApiStyleSpec := file("petstore.yaml"))
  .settings(
    openApiStyleValidateInfoLicense := Some(false),
    openApiStyleValidateInfoDescription := Some(false),
    openApiStyleValidateInfoContact := Some(false),

    openApiStyleValidateOperationId := Some(false),
    openApiStyleValidateOperationDescription := Some(false),
    openApiStyleValidateOperationTag := Some(false),
    openApiStyleValidateOperationSummary := Some(false),

    openApiStyleValidateModelPropertiesExample := Some(false),

    openApiStyleValidateNaming := Some(false),

    openApiStyleIgnoreHeaderXNaming := Some(false),

    openApiStylePathNamingConvention := None,
    openApiStyleParameterNamingConvention := None,
    openApiStyleHeaderNamingConvention := None,
    openApiStylePropertyNamingConvention := None
  )
  .settings(
    TaskKey[Unit]("check") := {
      val errors = openApiStyleValidationResult.value
      if (errors.nonEmpty) sys.error("Style validation errors found.")
      ()
    }
  )
