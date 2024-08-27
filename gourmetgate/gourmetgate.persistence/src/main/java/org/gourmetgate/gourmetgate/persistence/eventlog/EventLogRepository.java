package org.gourmetgate.gourmetgate.persistence.eventlog;

import org.gourmetgate.gourmetgate.data.eventlog.EventLogDo;
import org.gourmetgate.gourmetgate.data.eventlog.IEventLogRepository;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.EventLog;
import org.gourmetgate.gourmetgate.persistence.tables.records.EventLogRecord;
import org.jooq.Field;

public class EventLogRepository extends AbstractRepository<EventLog, EventLogRecord, EventLogDo> implements IEventLogRepository {

  @Override
  protected DoEntityBeanMappings<EventLogDo, EventLogRecord> mappings() {
    return new DoEntityBeanMappings<EventLogDo, EventLogRecord>()
      .with(EventLogDo::eventLogId, EventLogRecord::getEventLogId, EventLogRecord::setEventLogId)
      .with(EventLogDo::entityType, EventLogRecord::getEntityType, EventLogRecord::setEntityType)
      .with(EventLogDo::entityId, EventLogRecord::getEntityId, EventLogRecord::setEntityId)
      .with(EventLogDo::type, EventLogRecord::getType, EventLogRecord::setType)
      .with(EventLogDo::displayText, EventLogRecord::getDisplayText, EventLogRecord::setDisplayText)
      .with(EventLogDo::timestamp, EventLogRecord::getTimestamp, EventLogRecord::setTimestamp);
  }

  @Override
  public EventLog getTable() {
    return EventLog.EVENT_LOG;
  }

  @Override
  public Field<String> getIdColumn() {
    return getTable().EVENT_LOG_ID;
  }
}
