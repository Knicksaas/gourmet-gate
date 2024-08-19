package org.gourmetgate.gourmetgate.data.payment.wallee;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;
import org.eclipse.scout.rt.dataobject.ValueFormat;

import java.util.Date;

@TypeName("wallee.WebhookPayload")
public class WalleeWebhookPayloadDo extends DoEntity {

  private final static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXX";

  public DoValue<Long> eventId() {
    return doValue("eventId");
  }

  public DoValue<Long> entityId() {
    return doValue("entityId");
  }

  public DoValue<Long> listenerEntityId() {
    return doValue("listenerEntityId");
  }

  public DoValue<String> listenerEntityTechnicalName() {
    return doValue("listenerEntityTechnicalName");
  }

  public DoValue<String> spaceId() {
    return doValue("spaceId");
  }

  public DoValue<String> webhookListenerId() {
    return doValue("webhookListenerId");
  }

  @ValueFormat(pattern = DATE_FORMAT)
  public DoValue<Date> timestamp() {
    return doValue("timestamp");
  }

  public DoValue<String> state() {
    return doValue("state");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withEventId(Long eventId) {
    eventId().set(eventId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Long getEventId() {
    return eventId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withEntityId(Long entityId) {
    entityId().set(entityId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Long getEntityId() {
    return entityId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withListenerEntityId(Long listenerEntityId) {
    listenerEntityId().set(listenerEntityId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Long getListenerEntityId() {
    return listenerEntityId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withListenerEntityTechnicalName(String listenerEntityTechnicalName) {
    listenerEntityTechnicalName().set(listenerEntityTechnicalName);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getListenerEntityTechnicalName() {
    return listenerEntityTechnicalName().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withSpaceId(String spaceId) {
    spaceId().set(spaceId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getSpaceId() {
    return spaceId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withWebhookListenerId(String webhookListenerId) {
    webhookListenerId().set(webhookListenerId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getWebhookListenerId() {
    return webhookListenerId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withTimestamp(Date timestamp) {
    timestamp().set(timestamp);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Date getTimestamp() {
    return timestamp().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public WalleeWebhookPayloadDo withState(String state) {
    state().set(state);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getState() {
    return state().get();
  }
}
