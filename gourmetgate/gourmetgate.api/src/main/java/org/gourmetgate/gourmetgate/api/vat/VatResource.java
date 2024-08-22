package org.gourmetgate.gourmetgate.api.vat;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.vat.ReadVatPermission;
import org.gourmetgate.gourmetgate.core.vat.VatService;
import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupResultDo;

@Path("vat")
public class VatResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @POST
  @Path("lookup")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response postVatLookup(LookupRestrictionDo restriction) {
    if (!ACCESS.check(new ReadVatPermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    LookupResultDo result = BEANS.get(VatService.class).lookupVat(restriction);
    return m_restHelper.createJsonResponse(result);
  }
}
