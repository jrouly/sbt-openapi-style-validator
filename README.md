# sbt-openapi-style-validator

[![Scala CI](https://github.com/jrouly/sbt-openapi-style-validator/workflows/Scala%20CI/badge.svg?branch=master)](https://github.com/jrouly/sbt-openapi-style-validator/actions?query=workflow%3A%22Scala+CI%22)
[![Download](https://api.bintray.com/packages/jrouly/sbt-plugins/sbt-openapi-style-validator/images/download.svg)](https://bintray.com/jrouly/sbt-plugins/sbt-openapi-style-validator/_latestVersion)


An sbt plugin to support the [OpenAPI Style Validator](https://github.com/OpenAPITools/openapi-style-validator) project.

# Usage

Add to your `project/plugins.sbt`:

```sbt
resolvers += Resolver.bintrayIvyRepo("jrouly", "sbt-plugins")
addSbtPlugin("org.openapitools.openapistylevalidator" % "sbt-openapi-style-validator" % "version")
```

Update your `build.sbt`:
```sbt
enablePlugins(OpenApiStylePlugin)
openApiStyleSpec := file("openapi.yaml")
```

Invoke one of the provided tasks:
```
> openApiStyleValidate
> openApiStyleValidationResult
```

## Configuration

You may specify [openapi-style-validator](https://github.com/OpenAPITools/openapi-style-validator) settings either in a configuration file or directly in the sbt build definition using the provided keys.

### Using a configuration file

Supported formats include Java properties, [HOCON](https://github.com/lightbend/config/blob/master/HOCON.md) and JSON.

Specify the config file in `build.sbt`:
```sbt
openApiStyleConfig := Some(file("openapi-style-validator.conf"))
```

Specify configurations in the config file:
```hocon
validateNaming = true
pathNamingConvention = UnderscoreCase
// etc.
```

Keys are the same as in [openapi-style-validator](https://github.com/OpenAPITools/openapi-style-validator).

### Directly in sbt

You may also specify configuration settings directly in `build.sbt` via the provided keys:
```sbt
openApiStyleValidateNaming := Some(true)
openApiStylePathNamingConvention := Some(NamingConvention.UnderscoreCase)
// etc.
```

## sbt keys

| Key | Type | Description |
| --- | ---- | ----------- |
| `openApiStyleConfig` | `SettingKey[Option[File]]` | OpenAPI Style Validator configuration file. Defaults to `None`. |
| `openApiStyleSpec` | `TaskKey[File]` | OpenAPI specification file. |
| `openApiStyleValidate` | `TaskKey[Unit]` | Validates OpenAPI specification file: success or failure. |
| `openApiStyleValidationResult` | `TaskKey[Seq[String]]` | Validates OpenAPI specification file: evaluates to a list of detailed error messages. |
| `openApiStyleValidatorParameters` | `SettingKey[ValidatorParameters]` | OpenAPI Style Validator parameters, typically set using configuration keys or a configuration file. |

The following configuration keys are supported:

| Key | Type | Description |
| --- | ---- | ----------- |
| `openApiStyleValidateInfoLicense` | `SettingKey[Option[Boolean]]` | Ensures that there is a license section in the info section. |
| `openApiStyleValidateInfoDescription` | `SettingKey[Option[Boolean]]` | Ensures that there is a description attribute in the info section. |
| `openApiStyleValidateInfoContact` | `SettingKey[Option[Boolean]]` | Ensures that there is a contact section in the info section. |
| `openApiStyleValidateOperationId` | `SettingKey[Option[Boolean]]` | Ensures that there is an operation id for each operation. |
| `openApiStyleValidateOperationDescription` | `SettingKey[Option[Boolean]]` | Ensures that there is a description for each operation. |
| `openApiStyleValidateOperationTag` | `SettingKey[Option[Boolean]]` | Ensures that there is a tag for each operation. |
| `openApiStyleValidateOperationSummary` | `SettingKey[Option[Boolean]]` | Ensures that there is a summary for each operation. |
| `openApiStyleValidateModelPropertiesExample` | `SettingKey[Option[Boolean]]` | Ensures that the properties of the Schemas have an example value defined. |
| `openApiStyleValidateNaming` | `SettingKey[Option[Boolean]]` | Ensures the names follow a given naming convention. |
| `openApiStyleIgnoreHeaderXNaming` | `SettingKey[Option[Boolean]]` | Exclude from validation header parameters starting with `x-`. |
| `openApiStylePathNamingConvention` | `SettingKey[Option[NamingConvention]]` | Naming convention for paths. |
| `openApiStyleParameterNamingConvention` | `SettingKey[Option[NamingConvention]]` | Naming convention for parameters. |
| `openApiStyleHeaderNamingConvention` | `SettingKey[Option[NamingConvention]]` | Naming convention for headers. |
| `openApiStylePropertyNamingConvention` | `SettingKey[Option[NamingConvention]]` | Naming convention for properties. |

# Examples

Please see [an sbt-test configuration](src/sbt-test) for examples of using the plugin.
Do not run those examples directly, please copy them to separate place first.

# Contribution and testing

Write plugin integration tests under [src/sbt-test](src/sbt-test).

Execute next command to run tests:

```shell script
sbt scripted
```

More information about how to write and execute tests [is here](https://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

# Credits

Based heavily on [sbt-openapi-generator](https://github.com/OpenAPITools/sbt-openapi-generator).
