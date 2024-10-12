package org.gourmetgate.gourmetgate.interfaces.loyverse.rest;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.client.IRestResourceClient;
import org.gourmetgate.gourmetgate.interfaces.loyverse.data.category.LoyverseCategoryResponseDo;
import org.gourmetgate.gourmetgate.interfaces.loyverse.data.item.LoyverseItemResponseDo;

public class LoyverseResourceClient implements IRestResourceClient {

  protected static final String RESOURCE_PATH = "v1.0";

  protected LoyverseRestClientHelper helper() {
    return BEANS.get(LoyverseRestClientHelper.class);
  }

  public LoyverseCategoryResponseDo getAllCategories() {
    WebTarget target = helper()
      .target(RESOURCE_PATH)
      .path("/categories");

    return target.request()
      .headers(helper().getAuthorisationHeader())
      .accept(MediaType.APPLICATION_JSON)
      .get(LoyverseCategoryResponseDo.class);
  }

  public LoyverseItemResponseDo getAllItems() {
    WebTarget target = helper()
      .target(RESOURCE_PATH)
      .path("/items");

    return target.request()
      .headers(helper().getAuthorisationHeader())
      .accept(MediaType.APPLICATION_JSON)
      .get(LoyverseItemResponseDo.class);
  }
}
