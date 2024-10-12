package org.gourmetgate.gourmetgate.core.parameter;

public abstract class StringParameter extends AbstractParameter<String> {

  public StringParameter(String name) {
    super(name);
  }

  @Override
  protected String parseValue(String value) {
    return value;
  }

  @Override
  public String prepareValue(String value) {
    return value;
  }
}
