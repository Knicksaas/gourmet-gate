package org.gourmetgate.gourmetgate.api.order;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.core.order.OrderFormService;
import org.gourmetgate.gourmetgate.data.order.OrderFormDataResponse;

@Path("orderForm")
public class OrderFormResource implements IRestResource {

  @GET
  @Path("formData")
  @Produces(MediaType.APPLICATION_JSON)
  public OrderFormDataResponse getFormData() {
    return BEANS.get(OrderFormDataResponse.class)
      .withItem(BEANS.get(OrderFormService.class).getOrderFormData());
  }
}
