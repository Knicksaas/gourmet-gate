package org.gourmetgate.gourmetgate.data.table;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.HallFormData")
public class HallFormDataDo extends DoEntity {

  public DoList<TableDo> tables() {
    return doList("tables");
  }

  public DoValue<Integer> tableRowCount() {
    return doValue("tableRowCount");
  }

  public DoValue<Integer> tablesPerRowCount() {
    return doValue("tablesPerRowCount");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public HallFormDataDo withTables(Collection<? extends TableDo> tables) {
    tables().updateAll(tables);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public HallFormDataDo withTables(TableDo... tables) {
    tables().updateAll(tables);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<TableDo> getTables() {
    return tables().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public HallFormDataDo withTableRowCount(Integer tableRowCount) {
    tableRowCount().set(tableRowCount);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Integer getTableRowCount() {
    return tableRowCount().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public HallFormDataDo withTablesPerRowCount(Integer tablesPerRowCount) {
    tablesPerRowCount().set(tablesPerRowCount);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Integer getTablesPerRowCount() {
    return tablesPerRowCount().get();
  }
}
