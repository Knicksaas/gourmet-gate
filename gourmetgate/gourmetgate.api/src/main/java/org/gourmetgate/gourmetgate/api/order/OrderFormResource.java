package org.gourmetgate.gourmetgate.api.order;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.order.OrderService;
import org.gourmetgate.gourmetgate.data.payment.RedirectDo;

@Path("orderForm")
public class OrderFormResource implements IRestResource {

  RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("formData")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFormData(@CookieParam("JSESSIONID") Cookie cookie) {
    OrderService service = BEANS.get(OrderService.class);
    String orderId = service.getOrderIdForSession(cookie.getValue());
    if (orderId == null) {
      RedirectDo redirect = BEANS.get(RedirectDo.class).withRedirectUrl("user-guide.html");
      return m_restHelper.createJsonResponse(redirect);
    }
    return m_restHelper.createGenericJsonResponse(service.getOrderFormData(orderId));
  }
}
