/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables.records;


import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import java.math.BigDecimal;
import java.util.Date;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OrderRecord extends UpdatableRecordImpl<OrderRecord> implements Record7<String, String, String, BigDecimal, String, Date, Date> {

  private static final long serialVersionUID = 1L;

  /**
   * Setter for <code>Schema.order.ORDER_ID</code>.
   */
  public void setOrderId(String value) {
    set(0, value);
  }

  /**
   * Getter for <code>Schema.order.ORDER_ID</code>.
   */
  public String getOrderId() {
    return (String) get(0);
  }

  /**
   * Setter for <code>Schema.order.TABLE_ID</code>.
   */
  public void setTableId(String value) {
    set(1, value);
  }

  /**
   * Getter for <code>Schema.order.TABLE_ID</code>.
   */
  public String getTableId() {
    return (String) get(1);
  }

  /**
   * Setter for <code>Schema.order.STATUS</code>.
   */
  public void setStatus(String value) {
    set(2, value);
  }

  /**
   * Getter for <code>Schema.order.STATUS</code>.
   */
  public String getStatus() {
    return (String) get(2);
  }

  /**
   * Setter for <code>Schema.order.TIP</code>.
   */
  public void setTip(BigDecimal value) {
    set(3, value);
  }

  /**
   * Getter for <code>Schema.order.TIP</code>.
   */
  public BigDecimal getTip() {
    return (BigDecimal) get(3);
  }

  /**
   * Setter for <code>Schema.order.SESSION_ID</code>.
   */
  public void setSessionId(String value) {
    set(4, value);
  }

  /**
   * Getter for <code>Schema.order.SESSION_ID</code>.
   */
  public String getSessionId() {
    return (String) get(4);
  }

  /**
   * Setter for <code>Schema.order.EVT_CREATE</code>.
   */
  public void setEvtCreate(Date value) {
    set(5, value);
  }

  /**
     * Getter for <code>Schema.order.EVT_CREATE</code>.
   */
  public Date getEvtCreate() {
    return (Date) get(5);
  }

  /**
   * Setter for <code>Schema.order.EVT_PAY</code>.
   */
  public void setEvtPay(Date value) {
    set(6, value);
  }

  /**
   * Getter for <code>Schema.order.EVT_PAY</code>.
   */
  public Date getEvtPay() {
    return (Date) get(6);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<String> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record7 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row7<String, String, String, BigDecimal, String, Date, Date> fieldsRow() {
    return (Row7) super.fieldsRow();
  }

  @Override
  public Row7<String, String, String, BigDecimal, String, Date, Date> valuesRow() {
    return (Row7) super.valuesRow();
  }

  @Override
  public Field<String> field1() {
    return Order.ORDER.ORDER_ID;
  }

  @Override
  public Field<String> field2() {
    return Order.ORDER.TABLE_ID;
  }

  @Override
  public Field<String> field3() {
    return Order.ORDER.STATUS;
  }

  @Override
  public Field<BigDecimal> field4() {
    return Order.ORDER.TIP;
  }

  @Override
  public Field<String> field5() {
    return Order.ORDER.SESSION_ID;
  }

  @Override
  public Field<Date> field6() {
    return Order.ORDER.EVT_CREATE;
  }

  @Override
  public Field<Date> field7() {
    return Order.ORDER.EVT_PAY;
  }

  @Override
  public String component1() {
    return getOrderId();
  }

  @Override
  public String component2() {
    return getTableId();
  }

  @Override
  public String component3() {
    return getStatus();
  }

  @Override
  public BigDecimal component4() {
    return getTip();
  }

  @Override
  public String component5() {
    return getSessionId();
  }

  @Override
  public Date component6() {
    return getEvtCreate();
  }

  @Override
  public Date component7() {
    return getEvtPay();
  }

  @Override
  public String value1() {
    return getOrderId();
  }

  @Override
  public String value2() {
    return getTableId();
  }

  @Override
  public String value3() {
    return getStatus();
  }

  @Override
  public BigDecimal value4() {
    return getTip();
  }

  @Override
  public String value5() {
    return getSessionId();
  }

  @Override
  public Date value6() {
    return getEvtCreate();
  }

  @Override
  public Date value7() {
    return getEvtPay();
  }

  @Override
  public OrderRecord value1(String value) {
    setOrderId(value);
    return this;
  }

  @Override
  public OrderRecord value2(String value) {
    setTableId(value);
    return this;
  }

  @Override
  public OrderRecord value3(String value) {
    setStatus(value);
    return this;
  }

  @Override
  public OrderRecord value4(BigDecimal value) {
    setTip(value);
    return this;
  }

  @Override
  public OrderRecord value5(String value) {
    setSessionId(value);
    return this;
  }

  @Override
  public OrderRecord value6(Date value) {
    setEvtCreate(value);
    return this;
  }

  @Override
  public OrderRecord value7(Date value) {
    setEvtPay(value);
    return this;
  }

  @Override
  public OrderRecord values(String value1, String value2, String value3, BigDecimal value4, String value5, Date value6, Date value7) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    value5(value5);
    value6(value6);
    value7(value7);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /**
   * Create a detached OrderRecord
   */
  public OrderRecord() {
    super(Order.ORDER);
  }

  /**
   * Create a detached, initialised OrderRecord
   */
  public OrderRecord(String orderId, String tableId, String status, BigDecimal tip, String sessionId, Date evtCreate, Date evtPay) {
    super(Order.ORDER);

    setOrderId(orderId);
    setTableId(tableId);
    setStatus(status);
    setTip(tip);
    setSessionId(sessionId);
    setEvtCreate(evtCreate);
    setEvtPay(evtPay);
  }
}
