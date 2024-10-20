/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables.records;


import java.util.Date;

import org.gourmetgate.gourmetgate.persistence.tables.EventLog;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class EventLogRecord extends UpdatableRecordImpl<EventLogRecord> implements Record6<String, String, String, String, String, Date> {

  private static final long serialVersionUID = 1L;

  /**
   * Setter for <code>Schema.EVENT_LOG.EVENT_LOG_ID</code>.
   */
  public void setEventLogId(String value) {
    set(0, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.EVENT_LOG_ID</code>.
   */
  public String getEventLogId() {
    return (String) get(0);
  }

  /**
   * Setter for <code>Schema.EVENT_LOG.ENTITY_TYPE</code>.
   */
  public void setEntityType(String value) {
    set(1, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.ENTITY_TYPE</code>.
   */
  public String getEntityType() {
    return (String) get(1);
  }

  /**
   * Setter for <code>Schema.EVENT_LOG.ENTITY_ID</code>.
   */
  public void setEntityId(String value) {
    set(2, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.ENTITY_ID</code>.
   */
  public String getEntityId() {
    return (String) get(2);
  }

  /**
   * Setter for <code>Schema.EVENT_LOG.TYPE</code>.
   */
  public void setType(String value) {
    set(3, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.TYPE</code>.
   */
  public String getType() {
    return (String) get(3);
  }

  /**
   * Setter for <code>Schema.EVENT_LOG.DISPLAY_TEXT</code>.
   */
  public void setDisplayText(String value) {
    set(4, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.DISPLAY_TEXT</code>.
   */
  public String getDisplayText() {
    return (String) get(4);
  }

  /**
   * Setter for <code>Schema.EVENT_LOG.TIMESTAMP</code>.
   */
  public void setTimestamp(Date value) {
    set(5, value);
  }

  /**
   * Getter for <code>Schema.EVENT_LOG.TIMESTAMP</code>.
   */
  public Date getTimestamp() {
    return (Date) get(5);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<String> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record6 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row6<String, String, String, String, String, Date> fieldsRow() {
    return (Row6) super.fieldsRow();
  }

  @Override
  public Row6<String, String, String, String, String, Date> valuesRow() {
    return (Row6) super.valuesRow();
  }

  @Override
  public Field<String> field1() {
    return EventLog.EVENT_LOG.EVENT_LOG_ID;
  }

  @Override
  public Field<String> field2() {
    return EventLog.EVENT_LOG.ENTITY_TYPE;
  }

  @Override
  public Field<String> field3() {
    return EventLog.EVENT_LOG.ENTITY_ID;
  }

  @Override
  public Field<String> field4() {
    return EventLog.EVENT_LOG.TYPE;
  }

  @Override
  public Field<String> field5() {
    return EventLog.EVENT_LOG.DISPLAY_TEXT;
  }

  @Override
  public Field<Date> field6() {
    return EventLog.EVENT_LOG.TIMESTAMP;
  }

  @Override
  public String component1() {
    return getEventLogId();
  }

  @Override
  public String component2() {
    return getEntityType();
  }

  @Override
  public String component3() {
    return getEntityId();
  }

  @Override
  public String component4() {
    return getType();
  }

  @Override
  public String component5() {
    return getDisplayText();
  }

  @Override
  public Date component6() {
    return getTimestamp();
  }

  @Override
  public String value1() {
    return getEventLogId();
  }

  @Override
  public String value2() {
    return getEntityType();
  }

  @Override
  public String value3() {
    return getEntityId();
  }

  @Override
  public String value4() {
    return getType();
  }

  @Override
  public String value5() {
    return getDisplayText();
  }

  @Override
  public Date value6() {
    return getTimestamp();
  }

  @Override
  public EventLogRecord value1(String value) {
    setEventLogId(value);
    return this;
  }

  @Override
  public EventLogRecord value2(String value) {
    setEntityType(value);
    return this;
  }

  @Override
  public EventLogRecord value3(String value) {
    setEntityId(value);
    return this;
  }

  @Override
  public EventLogRecord value4(String value) {
    setType(value);
    return this;
  }

  @Override
  public EventLogRecord value5(String value) {
    setDisplayText(value);
    return this;
  }

  @Override
  public EventLogRecord value6(Date value) {
    setTimestamp(value);
    return this;
  }

  @Override
  public EventLogRecord values(String value1, String value2, String value3, String value4, String value5, Date value6) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    value5(value5);
    value6(value6);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /**
   * Create a detached EventLogRecord
   */
  public EventLogRecord() {
    super(EventLog.EVENT_LOG);
  }

  /**
   * Create a detached, initialised EventLogRecord
   */
  public EventLogRecord(String eventLogId, String entityType, String entityId, String type, String displayText, Date timestamp) {
    super(EventLog.EVENT_LOG);

    setEventLogId(eventLogId);
    setEntityType(entityType);
    setEntityId(entityId);
    setType(type);
    setDisplayText(displayText);
    setTimestamp(timestamp);
  }
}
