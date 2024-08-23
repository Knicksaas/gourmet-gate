package org.gourmetgate.gourmetgate.core.table;

import org.gourmetgate.gourmetgate.core.parameter.IntegerParameter;

public class TableRowCountParameter extends IntegerParameter {

  public TableRowCountParameter() {
    super("TableRowCountParameter");
  }

  @Override
  protected Integer getDefaultValue() {
    return 3;
  }
}
