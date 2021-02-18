package org.openapitools.generator.sbt.plugin.tasks

import org.openapitools.generator.sbt.plugin.OpenApiStyleKeys
import org.openapitools.openapistylevalidator.ValidatorParameters
import sbt._

trait OpenApiStyleValidatorParametersTask extends OpenApiStyleKeys {

  def openApiStyleValidatorParametersTask(): Def.Initialize[ValidatorParameters] = Def.setting {
    val parameters = new ValidatorParameters()

    openApiStyleValidateInfoLicense.value.foreach { setting =>
      parameters.setValidateInfoLicense(setting)
    }

    openApiStyleValidateInfoDescription.value.foreach { setting =>
      parameters.setValidateInfoDescription(setting)
    }

    openApiStyleValidateInfoContact.value.foreach { setting =>
      parameters.setValidateInfoContact(setting)
    }

    openApiStyleValidateOperationId.value.foreach { setting =>
      parameters.setValidateOperationOperationId(setting)
    }

    openApiStyleValidateOperationDescription.value.foreach { setting =>
      parameters.setValidateOperationDescription(setting)
    }

    openApiStyleValidateOperationTag.value.foreach { setting =>
      parameters.setValidateOperationTag(setting)
    }

    openApiStyleValidateOperationSummary.value.foreach { setting =>
      parameters.setValidateOperationSummary(setting)
    }

    openApiStyleValidateModelPropertiesExample.value.foreach { setting =>
      parameters.setValidateModelPropertiesExample(setting)
    }

    openApiStyleValidateNaming.value.foreach { setting =>
      parameters.setValidateNaming(setting)
    }

    openApiStyleIgnoreHeaderXNaming.value.foreach { setting =>
      parameters.setIgnoreHeaderXNaming(setting)
    }

    openApiStylePathNamingConvention.value.foreach { setting =>
      parameters.setPathNamingConvention(setting)
    }

    openApiStyleParameterNamingConvention.value.foreach { setting =>
      parameters.setParameterNamingConvention(setting)
    }

    openApiStyleHeaderNamingConvention.value.foreach { setting =>
      parameters.setHeaderNamingConvention(setting)
    }

    openApiStylePropertyNamingConvention.value.foreach { setting =>
      parameters.setParameterNamingConvention(setting)
    }

    parameters
  }

}
