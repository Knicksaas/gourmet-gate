package org.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.util.TypeCastUtility;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public abstract class AbstractRepository<TABLE extends Table<RECORD>, RECORD extends UpdatableRecord<RECORD>, DO extends DoEntity> implements IBaseService<TABLE, RECORD, DO> {

  protected abstract DoEntityBeanMappings<DO, RECORD> mappings();

  /**
   * Returns true if a record with the provided id exists using the specified
   * context
   */
  protected boolean exists(String id) {
    return jooq().fetchExists(jooq()
      .select()
      .from(getTable())
      .where(getIdColumn().eq(id)));
  }

  @Override
  public RECORD newRecord() {
    return jooq().newRecord(getTable());
  }

  @Override
  public DO create(DO entity) {
    RECORD newRecord = newRecord();
    String newId = UUID.randomUUID().toString();

    fromDoToRecord(entity, newRecord);
    setPrimaryKey(newRecord, newId);
    newRecord.store();
    return fromRecordToDo(newRecord, entity);
  }

  protected void setPrimaryKey(RECORD record, String key) {
    record.set(getIdColumn(), key);
  }

  public Optional<DO> getById(String id) {
    return get(id).map(this::fromRecordToDo);
  }

  public Stream<DO> all() {
    return getAll().map(this::fromRecordToDo);
  }

  @Override
  public Optional<RECORD> get(String id) {
    return Optional.ofNullable(
      jooq()
        .selectFrom(getTable())
        .where(getIdColumn().eq(id))
        .fetchOne());
  }

  @Override
  public Stream<RECORD> getAll() {
    return jooq()
      .selectFrom(getTable())
      .fetchStream();
  }

  public void update(String id, DO entity) {
    store(id, fromDoToRecord(entity));
  }

  @Override
  public void store(String id, RECORD record) {
    if (exists(id)) {
      jooq()
        .update(getTable())
        .set(record)
        .where(getIdColumn().eq(id))
        .execute();
    } else {
      jooq()
        .insertInto(getTable())
        .set(record)
        .execute();
    }
  }

  @Override
  public int delete(String id) {
    return jooq()
      .deleteFrom(getTable())
      .where(getIdColumn().eq(id))
      .execute();
  }


  // ------------------------
  // HELPER METHODS
  // ---------------------------
  protected RECORD fromDoToRecord(DO cDo, RECORD cBean) {
    mappings().fromDoToRecord(cDo, cBean);
    return cBean;
  }

  protected RECORD fromDoToRecord(DO cDo) {
    RECORD record = createEmptyRecord();
    mappings().fromDoToRecord(cDo, record);
    return record;
  }

  protected RECORD createEmptyRecord() {
    RECORD record = newRecord();
    record.detach();
    return record;
  }

  protected DO fromRecordToDo(RECORD cBean, DO cDo) {
    mappings().fromEntityBeanToDo(cBean, cDo);
    return cDo;
  }

  protected DO fromRecordToDo(RECORD cBean) {
    DO dataObject = createEmptyDo();
    mappings().fromEntityBeanToDo(cBean, dataObject);
    return dataObject;
  }

  @SuppressWarnings("unchecked")
  protected DO createEmptyDo() {
    Class<? extends DoEntity> doClass = TypeCastUtility.getGenericsParameterClass(this.getClass(), AbstractRepository.class, 2);
    return (DO) BEANS.get(doClass);
  }
}
