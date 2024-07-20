package org.gourmetgate.gourmetgate.data.table;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.gourmetgate.gourmetgate.data.common.EnumUtility;

public class TableDo extends DoEntity {

    public DoValue<String> tableId() {
        return doValue("tableId");
    }

    public DoValue<String> name() {
        return doValue("name");
    }

    public DoValue<String> status() {
        return doValue("status");
    }

  public TableDo withStatusEnum(TableStatus status) {
    return withStatus(status.name());
  }

  public TableStatus getStatusEnum() {
    return EnumUtility.getEnumFromString(TableStatus.class, getStatus());
  }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public TableDo withTableId(String tableId) {
        tableId().set(tableId);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getTableId() {
        return tableId().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public TableDo withName(String name) {
        name().set(name);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getName() {
        return name().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public TableDo withStatus(String status) {
        status().set(status);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getStatus() {
        return status().get();
    }
}
