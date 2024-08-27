package org.gourmetgate.gourmetgate.core.eventlog;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.common.EntityType;
import org.gourmetgate.gourmetgate.data.eventlog.EventLogDo;
import org.gourmetgate.gourmetgate.data.eventlog.EventLogType;
import org.gourmetgate.gourmetgate.data.eventlog.IEventLogRepository;
import org.gourmetgate.gourmetgate.data.eventlog.IEventLoggerService;

import java.util.Date;

public class EventLoggerService implements IEventLoggerService {

  @Override
  public void createLogEntry(EntityType entityType, String entityId, EventLogType type, String displayText) {
    EventLogDo eventLogEntry = BEANS.get(EventLogDo.class)
      .withEntityType(entityType.name())
      .withEntityId(entityId)
      .withType(type.name())
      .withDisplayText(displayText)
      .withTimestamp(new Date());
    BEANS.get(IEventLogRepository.class).create(eventLogEntry);
  }
}
