package org.gourmetgate.gourmetgate.persistence.table;

import org.gourmetgate.gourmetgate.data.table.ITableRepository;
import org.gourmetgate.gourmetgate.data.table.TableDo;
import org.gourmetgate.gourmetgate.data.table.TableStatus;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Table;
import org.gourmetgate.gourmetgate.persistence.tables.records.TableRecord;
import org.jooq.Field;

public class TableRepository extends AbstractRepository<Table, TableRecord, TableDo> implements ITableRepository {

  @Override
  public Table getTable() {
    return Table.TABLE;
  }

  @Override
  public Field<String> getIdColumn() {
    return Table.TABLE.TABLE_ID;
  }

  @Override
  public void updateStatus(String id, TableStatus tableStatus) {
    updateField(id, Table.TABLE.STATUS, tableStatus.name());
  }

  @Override
  protected DoEntityBeanMappings<TableDo, TableRecord> mappings() {
    return new DoEntityBeanMappings<TableDo, TableRecord>()
      .with(TableDo::tableId, TableRecord::getTableId, TableRecord::setTableId)
      .with(TableDo::name, TableRecord::getName, TableRecord::setName)
      .with(TableDo::status, TableRecord::getStatus, TableRecord::setStatus);
  }
}
