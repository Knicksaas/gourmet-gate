package org.gourmetgate.gourmetgate.core.table;

import org.gourmetgate.gourmetgate.core.parameter.IntegerParameter;

public class TablesPerRowParameter extends IntegerParameter {

  public TablesPerRowParameter() {
    super("TablesPerRowParameter");
  }

  @Override
  protected Integer getDefaultValue() {
    return 3;
  }
}
