/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables;


import org.gourmetgate.gourmetgate.persistence.Indexes;
import org.gourmetgate.gourmetgate.persistence.Keys;
import org.gourmetgate.gourmetgate.persistence.Schema;
import org.gourmetgate.gourmetgate.persistence.tables.records.PaymentRecord;
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
public class Payment extends TableImpl<PaymentRecord> {

  private static final long serialVersionUID = 1L;

  /**
   * The reference instance of <code>Schema.PAYMENT</code>
   */
  public static final Payment PAYMENT = new Payment();

  /**
   * The class holding records for this type
   */
  @Override
  public Class<PaymentRecord> getRecordType() {
    return PaymentRecord.class;
  }

  /**
   * The column <code>Schema.PAYMENT.PAYMENT_ID</code>.
   */
  public final TableField<PaymentRecord, String> PAYMENT_ID = createField(DSL.name("PAYMENT_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.PAYMENT.ORDER_ID</code>.
   */
  public final TableField<PaymentRecord, String> ORDER_ID = createField(DSL.name("ORDER_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.PAYMENT.STATUS</code>.
   */
  public final TableField<PaymentRecord, String> STATUS = createField(DSL.name("STATUS"), SQLDataType.VARCHAR(80).nullable(false), this, "");

  /**
   * The column <code>Schema.PAYMENT.PAYMENT_EXT_ID</code>.
   */
  public final TableField<PaymentRecord, String> PAYMENT_EXT_ID = createField(DSL.name("PAYMENT_EXT_ID"), SQLDataType.VARCHAR(80), this, "");

  private Payment(Name alias, Table<PaymentRecord> aliased) {
    this(alias, aliased, null);
  }

  private Payment(Name alias, Table<PaymentRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /**
   * Create an aliased <code>Schema.PAYMENT</code> table reference
   */
  public Payment(String alias) {
    this(DSL.name(alias), PAYMENT);
  }

  /**
   * Create an aliased <code>Schema.PAYMENT</code> table reference
   */
  public Payment(Name alias) {
    this(alias, PAYMENT);
  }

  /**
   * Create a <code>Schema.PAYMENT</code> table reference
   */
  public Payment() {
    this(DSL.name("PAYMENT"), null);
  }

  public <O extends Record> Payment(Table<O> child, ForeignKey<O, PaymentRecord> key) {
    super(child, key, PAYMENT);
  }

  @Override
  public org.jooq.Schema getSchema() {
    return aliased() ? null : Schema.SCHEMA;
  }

  @Override
  public List<Index> getIndexes() {
    return Arrays.asList(Indexes.SQL0000000001_40348015_0191_5BBA_9186_00000737EBB8);
  }

  @Override
  public UniqueKey<PaymentRecord> getPrimaryKey() {
    return Keys.PAYMENT_PK;
  }

  @Override
  public List<ForeignKey<PaymentRecord, ?>> getReferences() {
    return Arrays.asList(Keys.PAYMENT_ORDER_ORDER_ID_FK);
  }

  private transient Order _order;

  /**
   * Get the implicit join path to the <code>Schema.order</code> table.
   */
  public Order order() {
    if (_order == null)
      _order = new Order(this, Keys.PAYMENT_ORDER_ORDER_ID_FK);

    return _order;
  }

  @Override
  public Payment as(String alias) {
    return new Payment(DSL.name(alias), this);
  }

  @Override
  public Payment as(Name alias) {
    return new Payment(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public Payment rename(String name) {
    return new Payment(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public Payment rename(Name name) {
    return new Payment(name, null);
  }

  // -------------------------------------------------------------------------
  // Row4 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row4<String, String, String, String> fieldsRow() {
    return (Row4) super.fieldsRow();
  }
}
