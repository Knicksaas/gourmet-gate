package org.gourmetgate.gourmetgate.api.order;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.order.OrderFormService;
import org.gourmetgate.gourmetgate.core.orderposition.OrderPositionService;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionDo;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;

@Path("order")
public class OrderResource implements IRestResource {

  RestHelper m_restHelper;

  public OrderResource() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @POST
  @Path("position/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response createOrderPosition(@CookieParam("JSESSIONID") Cookie cookie, @PathParam("id") String articleId) {
    String orderId = BEANS.get(OrderFormService.class).getOrderIdForSession(cookie.getValue());
    if (orderId == null) {
      return m_restHelper.createBadRequestResponse("No order for current session");
    }

    GenericReponse<OrderPositionDo> response = m_restHelper.createGenericResponse(OrderPositionDo.class);
    response.withItem(BEANS.get(OrderPositionService.class).createOrderPosition(articleId, orderId));
    return m_restHelper.createJsonResponse(response);
  }

  @DELETE
  @Path("position/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteOrderPosition(@CookieParam("JSESSIONID") Cookie cookie, @PathParam("id") String orderPositionId) {
    // Check order
    String orderId = BEANS.get(OrderFormService.class).getOrderIdForSession(cookie.getValue());
    if (orderId == null) {
      return m_restHelper.createBadRequestResponse("No order for current session");
    }

    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(cookie.getValue(), orderPositionId)) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(OrderPositionService.class).deleteOrderPosition(orderPositionId);

    return m_restHelper.createOkResponse();
  }

  @GET
  @Path("position/{id}/options")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrderPositionOptions(@CookieParam("JSESSIONID") Cookie cookie, @PathParam("id") String orderPositionId) {
    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(cookie.getValue(), orderPositionId)) {
      return m_restHelper.createForbiddenResponse();
    }

    // Get entities
    GenericReponse<OrderPositionOptionDo> response = m_restHelper.createGenericResponse(OrderPositionOptionDo.class);
    response.withItems(BEANS.get(OrderPositionService.class).getOrCreateOrderPositionOptions(orderPositionId).toList());
    return m_restHelper.createJsonResponse(response);
  }

  @POST
  @Path("position/{id}/options")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateOrderPositionOptions(@CookieParam("JSESSIONID") Cookie cookie, @PathParam("id") String orderPositionId, GenericReponse<OrderPositionOptionDo> orderPositionOptions) {
    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(cookie.getValue(), orderPositionId)) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(OrderPositionService.class).updateOrderPositionOptions(orderPositionOptions.getItems());
    return m_restHelper.createOkResponse();
  }
}
