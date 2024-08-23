package org.gourmetgate.gourmetgate.api.order;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.core.order.OrderService;
import org.gourmetgate.gourmetgate.data.order.OrderFormDataResponse;

@Path("orderForm")
public class OrderFormResource implements IRestResource {

  @GET
  @Path("formData")
  @Produces(MediaType.APPLICATION_JSON)
  public OrderFormDataResponse getFormData(@CookieParam("JSESSIONID") Cookie cookie) {
    OrderService service = BEANS.get(OrderService.class);
    String orderId = service.getOrCreateOrderForSession(cookie.getValue(), "eaec9de9-3bc5-4981-bb0a-e02aa4c88b31");
    return BEANS.get(OrderFormDataResponse.class)
      .withItem(service.getOrderFormData(orderId));
  }
}
