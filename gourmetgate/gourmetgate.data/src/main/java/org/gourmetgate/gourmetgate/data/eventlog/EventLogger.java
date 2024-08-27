package org.gourmetgate.gourmetgate.data.eventlog;

import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.gourmetgate.gourmetgate.data.common.EntityType;

import java.util.Optional;

@Bean
public class EventLogger {

  private EntityType m_entityType;
  private IEventLoggerService m_service;

  @PostConstruct
  public void init() {
    m_service = BEANS.get(IEventLoggerService.class);
  }

  public void logCreatedEvent(String entityId, String displayText) {
    m_service.createLogEntry(getEntityType(), entityId, EventLogType.CREATED, displayText);
  }

  public void logUpdatedEvent(String entityId, String displayText) {
    m_service.createLogEntry(getEntityType(), entityId, EventLogType.UPDATED, displayText);
  }

  public void logDeletedEvent(String entityId, String displayText) {
    m_service.createLogEntry(getEntityType(), entityId, EventLogType.DELETED, displayText);
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
