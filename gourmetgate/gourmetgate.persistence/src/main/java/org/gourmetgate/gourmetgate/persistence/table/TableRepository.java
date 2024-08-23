package org.gourmetgate.gourmetgate.persistence.table;

import org.gourmetgate.gourmetgate.data.table.ITableRepository;
import org.gourmetgate.gourmetgate.data.table.TableDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Table;
import org.gourmetgate.gourmetgate.persistence.tables.records.TableRecord;
import org.jooq.Field;

import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

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
  public long getTableCount() {
    return all().count();
  }

  @Override
  public Stream<TableDo> all(long limit) {
    return jooq()
      .selectFrom(getTable())
      .maxRows(((int) limit))
      .stream()
      .map(this::fromRecordToDo);
  }

  @Override
  protected DoEntityBeanMappings<TableDo, TableRecord> mappings() {
    return new DoEntityBeanMappings<TableDo, TableRecord>()
      .with(TableDo::tableId, TableRecord::getTableId, TableRecord::setTableId)
      .with(TableDo::name, TableRecord::getName, TableRecord::setName)
      .with(TableDo::status, TableRecord::getStatus, TableRecord::setStatus);
  }
}
