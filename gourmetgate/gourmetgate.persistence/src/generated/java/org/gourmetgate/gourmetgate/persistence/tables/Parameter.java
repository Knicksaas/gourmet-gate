/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables;


import org.gourmetgate.gourmetgate.persistence.Keys;
import org.gourmetgate.gourmetgate.persistence.Schema;
import org.gourmetgate.gourmetgate.persistence.tables.records.ParameterRecord;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Parameter extends TableImpl<ParameterRecord> {

  private static final long serialVersionUID = 1L;

  /**
   * The reference instance of <code>Schema.PARAMETER</code>
   */
  public static final Parameter PARAMETER = new Parameter();

  /**
   * The class holding records for this type
   */
  @Override
  public Class<ParameterRecord> getRecordType() {
    return ParameterRecord.class;
  }

  /**
   * The column <code>Schema.PARAMETER.PARAMETER_ID</code>.
   */
  public final TableField<ParameterRecord, String> PARAMETER_ID = createField(DSL.name("PARAMETER_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.PARAMETER.NAME</code>.
   */
  public final TableField<ParameterRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(80).nullable(false), this, "");

  /**
   * The column <code>Schema.PARAMETER.VALUE</code>.
   */
  public final TableField<ParameterRecord, String> VALUE = createField(DSL.name("VALUE"), SQLDataType.VARCHAR(400), this, "");

  private Parameter(Name alias, Table<ParameterRecord> aliased) {
    this(alias, aliased, null);
  }

  private Parameter(Name alias, Table<ParameterRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /**
   * Create an aliased <code>Schema.PARAMETER</code> table reference
   */
  public Parameter(String alias) {
    this(DSL.name(alias), PARAMETER);
  }

  /**
   * Create an aliased <code>Schema.PARAMETER</code> table reference
   */
  public Parameter(Name alias) {
    this(alias, PARAMETER);
  }

  /**
   * Create a <code>Schema.PARAMETER</code> table reference
   */
  public Parameter() {
    this(DSL.name("PARAMETER"), null);
  }

  public <O extends Record> Parameter(Table<O> child, ForeignKey<O, ParameterRecord> key) {
    super(child, key, PARAMETER);
  }

  @Override
  public org.jooq.Schema getSchema() {
    return aliased() ? null : Schema.SCHEMA;
  }

  @Override
  public UniqueKey<ParameterRecord> getPrimaryKey() {
    return Keys.PARAMETER_PK;
  }

  @Override
  public List<UniqueKey<ParameterRecord>> getUniqueKeys() {
    return Arrays.asList(Keys.PARAMETER_PK_2);
  }

  @Override
  public Parameter as(String alias) {
    return new Parameter(DSL.name(alias), this);
  }

  @Override
  public Parameter as(Name alias) {
    return new Parameter(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public Parameter rename(String name) {
    return new Parameter(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public Parameter rename(Name name) {
    return new Parameter(name, null);
  }

  // -------------------------------------------------------------------------
  // Row3 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row3<String, String, String> fieldsRow() {
    return (Row3) super.fieldsRow();
  }
}
