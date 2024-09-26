package org.gourmetgate.gourmetgate.api.order;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.order.OrderService;
import org.gourmetgate.gourmetgate.core.orderposition.OrderPositionService;
import org.gourmetgate.gourmetgate.core.table.TableService;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionDo;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;

@Path("order")
public class OrderResource implements IRestResource {

  RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("/")
  public Response initiateOrderByLink(@QueryParam("tableId") String tableId, @Context HttpServletRequest request) {
    if (!BEANS.get(TableService.class).tableExists(tableId)) {
      return m_restHelper.createNotFoundResponse();
    }

    BEANS.get(OrderService.class).getOrCreateOrderForSession(request.getSession().getId(), tableId);
    return m_restHelper.createTemoraryServerRedirectResponse("/");
  }


  @POST
  @Path("position/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response createOrderPosition(@PathParam("id") String articleId, @Context HttpServletRequest request) {
    String orderId = BEANS.get(OrderService.class).getOrderIdForSession(request.getSession().getId());
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
  public Response deleteOrderPosition(@PathParam("id") String orderPositionId, @Context HttpServletRequest request) {
    // Check order
    String orderId = BEANS.get(OrderService.class).getOrderIdForSession(request.getSession().getId());
    if (orderId == null) {
      return m_restHelper.createBadRequestResponse("No order for current session");
    }

    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(request.getSession().getId(), orderPositionId)) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(OrderPositionService.class).deleteOrderPosition(orderPositionId);

    return m_restHelper.createOkResponse();
  }

  @GET
  @Path("position/{id}/options")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrderPositionOptions(@Context HttpServletRequest request, @PathParam("id") String orderPositionId) {
    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(request.getSession().getId(), orderPositionId)) {
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
  public Response updateOrderPositionOptions(@PathParam("id") String orderPositionId, @Context HttpServletRequest request, GenericReponse<OrderPositionOptionDo> orderPositionOptions) {
    // Check access
    if (!m_restHelper.checkAccessToOrderPosition(request.getSession().getId(), orderPositionId)) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(OrderPositionService.class).updateOrderPositionOptions(orderPositionOptions.getItems());
    return m_restHelper.createOkResponse();
  }
}
