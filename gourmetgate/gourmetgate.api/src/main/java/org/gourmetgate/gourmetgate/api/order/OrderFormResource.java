package org.gourmetgate.gourmetgate.api.order;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.order.OrderService;

@Path("orderForm")
public class OrderFormResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("formData")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFormData(@Context HttpServletRequest request) {
    OrderService service = BEANS.get(OrderService.class);
    String orderId = service.getOrderIdForSession(request.getSession().getId());
    if (orderId == null) {
      return m_restHelper.createTemoraryJsRedirectResponse("../#userGuide");
    }
    return m_restHelper.createGenericJsonResponse(service.getOrderFormData(orderId));
  }
}
