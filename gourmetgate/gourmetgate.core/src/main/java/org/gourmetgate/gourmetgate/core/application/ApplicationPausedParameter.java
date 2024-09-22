package org.gourmetgate.gourmetgate.core.application;

import org.gourmetgate.gourmetgate.core.parameter.BooleanParameter;

public class ApplicationPausedParameter extends BooleanParameter {

  public ApplicationPausedParameter() {
    super("ApplicationPausedParameter");
  }

  @Override
  protected Boolean getDefaultValue() {
    return false;
  }

  @Override
  protected boolean getConfiguredEditableInApplication() {
    return true;
  }
}
