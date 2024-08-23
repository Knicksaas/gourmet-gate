package org.gourmetgate.gourmetgate.core.parameter;

public class IntegerParameter extends AbstractParameter<Integer> {

  public IntegerParameter(String name) {
    super(name);
  }

  @Override
  protected Integer parseValue(String value) {
    return Integer.valueOf(value);
  }

  @Override
  public String prepareValue(Integer value) {
    return Integer.toString(value);
  }
}
