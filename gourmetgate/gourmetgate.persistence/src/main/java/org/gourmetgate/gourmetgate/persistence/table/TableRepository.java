package org.gourmetgate.gourmetgate.persistence.table;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.table.ITableRepository;
import org.gourmetgate.gourmetgate.data.table.TableDo;
import org.gourmetgate.gourmetgate.data.table.TableStatus;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Table;
import org.gourmetgate.gourmetgate.persistence.tables.records.TableRecord;
import org.jooq.Field;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

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
  public TableDo create(TableDo entity) {
    TableRecord newTableRecord = newRecord();
    String newTableId = UUID.randomUUID().toString();

    fromDoToRecord(entity, newTableRecord)
      .setTableId(newTableId);
    newTableRecord.store();
    return fromRecordToDo(newTableRecord, entity);
  }

  @Override
  public Optional<TableDo> getById(String id) {
    return get(id).map(this::recToDo);
  }

  @Override
  public Stream<TableDo> all() {
    return getAll().map(this::recToDo);
  }

  @Override
  public void update(String id, TableDo entity) {
    super.store(id, doToRec(entity));
  }

  @Override
  public int delte(String id) {
    return remove(id);
  }

  @Override
  public void updateStatus(TableStatus tableStatus) {

  }

  @Override
  protected DoEntityBeanMappings<TableDo, TableRecord> mappings() {
    return new DoEntityBeanMappings<TableDo, TableRecord>()
      .with(TableDo::tableId, TableRecord::getTableId)
      .with(TableDo::name, TableRecord::getName)
      .with(TableDo::status, TableRecord::getStatus);
  }

  protected TableDo recToDo(TableRecord tableRecord) {
    return fromRecordToDo(tableRecord, BEANS.get(TableDo.class));
  }

  protected TableRecord doToRec(TableDo table) {
    return fromDoToRecord(table, new TableRecord());
  }
}
