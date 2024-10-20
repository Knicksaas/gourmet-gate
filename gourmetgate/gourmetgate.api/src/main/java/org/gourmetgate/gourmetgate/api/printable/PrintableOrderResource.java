package org.gourmetgate.gourmetgate.api.printable;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.printable.PrintableOrderService;
import org.gourmetgate.gourmetgate.data.printable.PrintableOrderDo;

import java.util.List;

@Path("printable/orders")
public class PrintableOrderResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUnprintedOrders() {
    // TODO add access check

    List<PrintableOrderDo> unprintedOrders = BEANS.get(PrintableOrderService.class).getUnprintedOrders();
    return m_restHelper.createGenericJsonResponse(unprintedOrders);
  }

  @POST
  @Path("/markAsPrinted")
  public Response markOrdersAsPrinted(MarkOrderAsPrintedRequestDo requestDo) {
    // TODO add access check

    BEANS.get(PrintableOrderService.class).markOrdersAsPrinted(requestDo.getPrintedOrderIds());
    return m_restHelper.createOkResponse();
  }
}
