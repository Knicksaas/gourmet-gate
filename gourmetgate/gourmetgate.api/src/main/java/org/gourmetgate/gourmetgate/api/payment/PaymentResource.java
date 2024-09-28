package org.gourmetgate.gourmetgate.api.payment;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.order.OrderService;
import org.gourmetgate.gourmetgate.core.payment.PaymentService;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.infopage.InfoTileBeanDo;
import org.gourmetgate.gourmetgate.data.payment.RedirectDo;

@Path("payment")
public class PaymentResource implements IRestResource {

  private final RestHelper m_restHelper;

  public PaymentResource() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @POST
  @Path("/")
  public Response createPayment(@Context HttpServletRequest request) {
    String orderId = BEANS.get(OrderService.class).getOrderIdForSession(request.getSession().getId());
    if (orderId == null) {
      return m_restHelper.createBadRequestResponse("No order for current session");
    }

    String paymentUrl = BEANS.get(PaymentService.class).createPayment(orderId);
    RedirectDo redirectDo = BEANS.get(RedirectDo.class).withRedirectUrl(paymentUrl);
    GenericReponse<RedirectDo> response = m_restHelper
      .createGenericResponse(RedirectDo.class)
      .withItem(redirectDo);

    return m_restHelper.createJsonResponse(response);
  }

  @GET
  @Path("/status")
  public Response getPaymentStatus(@Context HttpServletRequest request) {
    String orderId = BEANS.get(OrderService.class).getOrderIdForSession(request.getSession().getId());
    if (orderId == null) {
      return m_restHelper.createBadRequestResponse("No order for current session");
    }

    InfoTileBeanDo responseDo = BEANS.get(PaymentService.class).getPaymentStatusDo(orderId);
    return m_restHelper.createGenericJsonResponse(responseDo);
  }
}
