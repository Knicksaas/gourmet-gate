package org.gourmetgate.gourmetgate.data.eventlog;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Date;

@TypeName("gourmetgate.EventLog")
public class EventLogDo extends DoEntity {

  public DoValue<String> eventLogId() {
    return doValue("eventLogId");
  }

  public DoValue<String> entityType() {
    return doValue("entityType");
  }

  public DoValue<String> entityId() {
    return doValue("entityId");
  }

  public DoValue<String> type() {
    return doValue("type");
  }

  public DoValue<String> displayText() {
    return doValue("displayText");
  }

  public DoValue<Date> timestamp() {
    return doValue("timestamp");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withEventLogId(String eventLogId) {
    eventLogId().set(eventLogId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getEventLogId() {
    return eventLogId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withEntityType(String entityType) {
    entityType().set(entityType);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getEntityType() {
    return entityType().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withEntityId(String entityId) {
    entityId().set(entityId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getEntityId() {
    return entityId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withType(String type) {
    type().set(type);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getType() {
    return type().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withDisplayText(String displayText) {
    displayText().set(displayText);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDisplayText() {
    return displayText().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public EventLogDo withTimestamp(Date timestamp) {
    timestamp().set(timestamp);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Date getTimestamp() {
    return timestamp().get();
  }
}
