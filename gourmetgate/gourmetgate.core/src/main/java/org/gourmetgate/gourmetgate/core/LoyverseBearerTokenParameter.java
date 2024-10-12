package org.gourmetgate.gourmetgate.core;

import org.gourmetgate.gourmetgate.core.parameter.StringParameter;

public class LoyverseBearerTokenParameter extends StringParameter {

  public LoyverseBearerTokenParameter() {
    super("LoyverseBearerTokenParameter");
  }

  @Override
  protected boolean getConfiguredEditableInApplication() {
    return true;
  }
}
