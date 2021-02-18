# sbt-openapi-style-validator

[![Scala CI](https://github.com/jrouly/sbt-openapi-style-validator/workflows/Scala%20CI/badge.svg?branch=master)](https://github.com/jrouly/sbt-openapi-style-validator/actions?query=workflow%3A%22Scala+CI%22)
[![Download](https://api.bintray.com/packages/jrouly/sbt-plugins/sbt-openapi-style-validator/images/download.svg)](https://bintray.com/jrouly/sbt-plugins/sbt-openapi-style-validator/_latestVersion)


An sbt plugin to support the [OpenAPI Style Validator](https://github.com/OpenAPITools/openapi-style-validator) project.

# Usage

Add to your `project/plugins.sbt`:

```sbt
addSbtPlugin("org.openapitools.openapistylevalidator" % "sbt-openapi-style-validator" % "version")
```

Update your `build.sbt`:
```sbt
enablePlugins(OpenApiStylePlugin)
openApiStyleFile := file("openapi.yaml")
```

Invoke one of the provided tasks:
```
> openApiStyleValidate
```

# sbt keys

| Key | Type | Description |
| ------- | ---- | ----------- |
| `openApiStyleFile` | `TaskKey[sbt.File]` | OpenAPI specification file. |
| `openApiStyleValidate` | `TaskKey[Unit]` | Validates styles for the OpenAPI specification file. |

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
