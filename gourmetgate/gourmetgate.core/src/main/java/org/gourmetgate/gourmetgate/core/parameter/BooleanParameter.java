package org.gourmetgate.gourmetgate.core.parameter;

public class BooleanParameter extends AbstractParameter<Boolean> {

  public BooleanParameter(String name) {
    super(name);
  }

  @Override
  protected Boolean parseValue(String value) {
    return Boolean.valueOf(value);
  }

  @Override
  public String prepareValue(Boolean value) {
    return Boolean.toString(value);
  }
}
