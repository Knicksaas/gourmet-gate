package org.gourmetgate.gourmetgate.api.webhooks;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.payment.PaymentService;
import org.gourmetgate.gourmetgate.data.payment.wallee.WalleeWebhookPayloadDo;

@Path("webhook")
public class WebhookResource implements IRestResource {

  @POST
  @Path("/wallee/transaction")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response postWalleeTransactionUpdate(WalleeWebhookPayloadDo webhookPayload) {
    BEANS.get(PaymentService.class).registerTransactionChange(String.valueOf(webhookPayload.getEntityId()));
    return BEANS.get(RestHelper.class).createOkResponse();
  }
}
