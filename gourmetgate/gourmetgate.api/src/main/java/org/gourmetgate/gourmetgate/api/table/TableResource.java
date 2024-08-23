package org.gourmetgate.gourmetgate.api.table;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.table.ReadHallFormDataPermission;
import org.gourmetgate.gourmetgate.core.table.RegenerateTablesPermission;
import org.gourmetgate.gourmetgate.core.table.TableService;
import org.gourmetgate.gourmetgate.data.table.HallFormDataDo;

@Path("table")
public class TableResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @POST
  @Path("regenerate")
  public Response regenerateTableLayout() {
    if (!ACCESS.check(new RegenerateTablesPermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(TableService.class).regenerateTableLayout();
    return m_restHelper.createGenericJsonResponse(BEANS.get(TableService.class).getHallFormData());
  }

  @GET
  @Path("hallFormData")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHallFormData() {
    if (!ACCESS.check(new ReadHallFormDataPermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    HallFormDataDo hallFormData = BEANS.get(TableService.class).getHallFormData();
    return m_restHelper.createGenericJsonResponse(hallFormData);
  }
}
