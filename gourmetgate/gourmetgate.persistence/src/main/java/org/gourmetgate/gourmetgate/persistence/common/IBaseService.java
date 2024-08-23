package org.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public interface IBaseService<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> {

  /**
   * @return the table object associated with this service.
   */
  TABLE getTable();

  /**
   * @return the id column for the table object associated with this service.
   */
  Field<String> getIdColumn();

  /**
   * @return A new empty record.
   */
  RECORD newRecord();

  /**
   * Creates a new record in the database.
   *
   * @param entity new record as DO
   * @return the persisted record with filled primary key
   */
  DO create(DO entity);

  /**
   * Gets the record for the specified id.
   *
   * @return the record for the id given or an empty {@link Optional} if the id could not be found.
   */
  Optional<RECORD> get(String id);

  /**
   * @return all available records.
   */
  Stream<RECORD> getAll();

  /**
   * Persists the provided record based on the id specified. If no record with this id exists, a new record is created.
   * Otherwise, the existing record is updated.
   */
  int store(String id, RECORD record);

  /**
   * Deletes the record with the specified id
   *
   * @return the number of records deleted
   */
  int delete(String id);

}
