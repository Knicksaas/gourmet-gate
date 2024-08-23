package org.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.PlatformException;
import org.eclipse.scout.rt.platform.util.TypeCastUtility;
import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import java.util.ArrayList;
import java.util.List;
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

  public int update(String id, DO entity) {
    return store(id, fromDoToRecord(entity));
  }

  @Override
  public int store(String id, RECORD record) {
    if (exists(id)) {
      return jooq()
        .update(getTable())
        .set(record)
        .where(getIdColumn().eq(id))
        .execute();
    } else {
      return jooq()
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

  public Stream<DO> search(LookupRestrictionDo restriction) {
    return jooq()
      .selectFrom(getTable())
      .where(buildSearchCondition(restriction))
      .stream()
      .map(this::fromRecordToDo);
  }

  protected List<Condition> buildSearchCondition(LookupRestrictionDo restriction) {
    List<Condition> conditions = new ArrayList<>();
    if (restriction.ids().exists()) {
      conditions.add(getIdColumn().in(restriction.getIds()));
    }
    if (restriction.text().exists()) {
      conditions.add(getTextColumn().eq(restriction.getText()));
    }
    return conditions;
  }

  protected Field<String> getTextColumn() {
    throw new PlatformException("Override getTextColumn in your repository to enable lookup by text");
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
