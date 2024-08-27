package org.gourmetgate.gourmetgate.core.eventlog;

import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.gourmetgate.gourmetgate.data.common.EntityType;

import java.util.Optional;

@Bean
public class EventLogger {

  private EntityType m_entityType;
  private EventLoggerService m_service;

  @PostConstruct
  public void init() {
    m_service = BEANS.get(EventLoggerService.class);
  }

  void logCreatedEvent(String entityId, String displayText) {
    m_service.createLogEntry(getEntityType(), entityId, EventLogType.CREATED, displayText);
  }


  public EventLogger withEntityType(EntityType type) {
    m_entityType = type;
    return this;
  }

  private EntityType getEntityType() {
    return Optional.ofNullable(m_entityType)
      .orElseThrow();
  }
}
