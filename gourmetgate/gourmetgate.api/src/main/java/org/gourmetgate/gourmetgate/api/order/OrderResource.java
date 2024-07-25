package org.gourmetgate.gourmetgate.api.order;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.dataobject.IDataObjectMapper;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.core.order.OrderFormService;
import org.gourmetgate.gourmetgate.core.orderposition.OrderPositionService;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionResponse;

@Path("order")
public class OrderResource implements IRestResource {

  @POST
  @Path("position/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addPosition(@CookieParam("JSESSIONID") Cookie cookie, @PathParam("id") String articleId) {
    String orderId = BEANS.get(OrderFormService.class).getOrderIdForSession(cookie.getValue());
    if (orderId == null) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity("No order for current session")
        .build();
    }
    OrderPositionResponse response = BEANS.get(OrderPositionResponse.class)
      .withItems(BEANS.get(OrderPositionService.class).addArticleToOrder(articleId, orderId).toList());

    return Response.ok(BEANS.get(IDataObjectMapper.class).writeValue(response)).build();
  }
}
