/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables.records;


import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import java.math.BigDecimal;
import java.util.Date;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OrderRecord extends UpdatableRecordImpl<OrderRecord> implements Record8<String, String, String, BigDecimal, Date, Date, String, Boolean> {

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
   * Setter for <code>Schema.order.EVT_CREATE</code>.
   */
  public void setEvtCreate(Date value) {
    set(4, value);
  }

  /**
   * Getter for <code>Schema.order.EVT_CREATE</code>.
   */
  public Date getEvtCreate() {
    return (Date) get(4);
  }

  /**
   * Setter for <code>Schema.order.EVT_PAY</code>.
   */
  public void setEvtPay(Date value) {
    set(5, value);
  }

  /**
   * Getter for <code>Schema.order.EVT_PAY</code>.
   */
  public Date getEvtPay() {
    return (Date) get(5);
  }

  /**
   * Setter for <code>Schema.order.SESSION_ID</code>.
   */
  public void setSessionId(String value) {
    set(6, value);
  }

  /**
   * Getter for <code>Schema.order.SESSION_ID</code>.
   */
  public String getSessionId() {
    return (String) get(6);
  }

  /**
   * Setter for <code>Schema.order.PRINTED</code>.
   */
  public void setPrinted(Boolean value) {
    set(7, value);
  }

  /**
   * Getter for <code>Schema.order.PRINTED</code>.
   */
  public Boolean getPrinted() {
    return (Boolean) get(7);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<String> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record8 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row8<String, String, String, BigDecimal, Date, Date, String, Boolean> fieldsRow() {
    return (Row8) super.fieldsRow();
  }

  @Override
  public Row8<String, String, String, BigDecimal, Date, Date, String, Boolean> valuesRow() {
    return (Row8) super.valuesRow();
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
  public Field<Date> field5() {
    return Order.ORDER.EVT_CREATE;
  }

  @Override
  public Field<Date> field6() {
    return Order.ORDER.EVT_PAY;
  }

  @Override
  public Field<String> field7() {
    return Order.ORDER.SESSION_ID;
  }

  @Override
  public Field<Boolean> field8() {
    return Order.ORDER.PRINTED;
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
  public Date component5() {
    return getEvtCreate();
  }

  @Override
  public Date component6() {
    return getEvtPay();
  }

  @Override
  public String component7() {
    return getSessionId();
  }

  @Override
  public Boolean component8() {
    return getPrinted();
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
  public Date value5() {
    return getEvtCreate();
  }

  @Override
  public Date value6() {
    return getEvtPay();
  }

  @Override
  public String value7() {
    return getSessionId();
  }

  @Override
  public Boolean value8() {
    return getPrinted();
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
  public OrderRecord value5(Date value) {
    setEvtCreate(value);
    return this;
  }

  @Override
  public OrderRecord value6(Date value) {
    setEvtPay(value);
    return this;
  }

  @Override
  public OrderRecord value7(String value) {
    setSessionId(value);
    return this;
  }

  @Override
  public OrderRecord value8(Boolean value) {
    setPrinted(value);
    return this;
  }

  @Override
  public OrderRecord values(String value1, String value2, String value3, BigDecimal value4, Date value5, Date value6, String value7, Boolean value8) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    value5(value5);
    value6(value6);
    value7(value7);
    value8(value8);
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
  public OrderRecord(String orderId, String tableId, String status, BigDecimal tip, Date evtCreate, Date evtPay, String sessionId, Boolean printed) {
    super(Order.ORDER);

    setOrderId(orderId);
    setTableId(tableId);
    setStatus(status);
    setTip(tip);
    setEvtCreate(evtCreate);
    setEvtPay(evtPay);
    setSessionId(sessionId);
    setPrinted(printed);
  }
}
