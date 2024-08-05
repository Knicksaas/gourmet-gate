package org.gourmetgate.gourmetgate.api.cart;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.cart.CartFormService;
import org.gourmetgate.gourmetgate.core.order.OrderFormService;
import org.gourmetgate.gourmetgate.data.cart.CartFormDataDo;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;

@Path("cart")
public class CartResource implements IRestResource {

  @GET
  @Path("formData")
  @Produces(MediaType.APPLICATION_JSON)
  public GenericReponse<CartFormDataDo> getFormData(@CookieParam("JSESSIONID") Cookie cookie) {
    String orderId = BEANS.get(OrderFormService.class).getOrCreateOrderForSession(cookie.getValue(), "eaec9de9-3bc5-4981-bb0a-e02aa4c88b31");
    return BEANS.get(RestHelper.class).createGenericResponse(CartFormDataDo.class)
      .withItem(BEANS.get(CartFormService.class).getCartFormData(orderId));
  }
}
