/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables;


import org.gourmetgate.gourmetgate.persistence.Keys;
import org.gourmetgate.gourmetgate.persistence.Schema;
import org.gourmetgate.gourmetgate.persistence.common.DateConverter;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderRecord;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Order extends TableImpl<OrderRecord> {

  private static final long serialVersionUID = 1L;

  /**
   * The reference instance of <code>Schema.order</code>
   */
  public static final Order ORDER = new Order();

  /**
   * The class holding records for this type
   */
  @Override
  public Class<OrderRecord> getRecordType() {
    return OrderRecord.class;
  }

  /**
   * The column <code>Schema.order.ORDER_ID</code>.
   */
  public final TableField<OrderRecord, String> ORDER_ID = createField(DSL.name("ORDER_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.order.TABLE_ID</code>.
   */
  public final TableField<OrderRecord, String> TABLE_ID = createField(DSL.name("TABLE_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.order.STATUS</code>.
   */
  public final TableField<OrderRecord, String> STATUS = createField(DSL.name("STATUS"), SQLDataType.VARCHAR(80).nullable(false), this, "");

  /**
   * The column <code>Schema.order.TIP</code>.
   */
  public final TableField<OrderRecord, BigDecimal> TIP = createField(DSL.name("TIP"), SQLDataType.DECIMAL(15, 10).nullable(false).defaultValue(DSL.field("0.0", SQLDataType.DECIMAL)), this, "");

  /**
   * The column <code>Schema.order.SESSION_ID</code>.
   */
  public final TableField<OrderRecord, String> SESSION_ID = createField(DSL.name("SESSION_ID"), SQLDataType.VARCHAR(36).nullable(false).defaultValue(DSL.field("''", SQLDataType.VARCHAR)), this, "");

  /**
   * The column <code>Schema.order.EVT_CREATE</code>.
   */
  public final TableField<OrderRecord, Date> EVT_CREATE = createField(DSL.name("EVT_CREATE"), SQLDataType.LOCALDATETIME(9).nullable(false).defaultValue(DSL.field("'1960-01-01 23:03:20'", SQLDataType.LOCALDATETIME)), this, "", new DateConverter());

  /**
     * The column <code>Schema.order.EVT_PAY</code>.
   */
  public final TableField<OrderRecord, Date> EVT_PAY = createField(DSL.name("EVT_PAY"), SQLDataType.LOCALDATETIME(9), this, "", new DateConverter());

  private Order(Name alias, Table<OrderRecord> aliased) {
    this(alias, aliased, null);
  }

  private Order(Name alias, Table<OrderRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /**
   * Create an aliased <code>Schema.order</code> table reference
   */
  public Order(String alias) {
    this(DSL.name(alias), ORDER);
  }

  /**
   * Create an aliased <code>Schema.order</code> table reference
   */
  public Order(Name alias) {
    this(alias, ORDER);
  }

  /**
   * Create a <code>Schema.order</code> table reference
   */
  public Order() {
    this(DSL.name("order"), null);
  }

  public <O extends Record> Order(Table<O> child, ForeignKey<O, OrderRecord> key) {
    super(child, key, ORDER);
  }

  @Override
  public org.jooq.Schema getSchema() {
    return aliased() ? null : Schema.SCHEMA;
  }

  @Override
  public UniqueKey<OrderRecord> getPrimaryKey() {
    return Keys.ORDER_PK;
  }

  @Override
  public List<ForeignKey<OrderRecord, ?>> getReferences() {
    return Arrays.asList(Keys.ORDER_TABLE_TABLE_ID_FK);
  }

  private transient org.gourmetgate.gourmetgate.persistence.tables.Table _table;

  /**
   * Get the implicit join path to the <code>Schema.table</code> table.
   */
  public org.gourmetgate.gourmetgate.persistence.tables.Table table() {
    if (_table == null)
      _table = new org.gourmetgate.gourmetgate.persistence.tables.Table(this, Keys.ORDER_TABLE_TABLE_ID_FK);

    return _table;
  }

  @Override
  public Order as(String alias) {
    return new Order(DSL.name(alias), this);
  }

  @Override
  public Order as(Name alias) {
    return new Order(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public Order rename(String name) {
    return new Order(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public Order rename(Name name) {
    return new Order(name, null);
  }

  // -------------------------------------------------------------------------
  // Row7 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row7<String, String, String, BigDecimal, String, Date, Date> fieldsRow() {
    return (Row7) super.fieldsRow();
  }
}
