package org.gourmetgate.gourmetgate.data.eventlog;

import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.common.EntityType;

public interface IEventLoggerService extends IService {

  void createLogEntry(EntityType entityType, String entityId, EventLogType type, String displayText);
}
