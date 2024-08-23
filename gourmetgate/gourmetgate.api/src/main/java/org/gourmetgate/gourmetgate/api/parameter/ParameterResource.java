package org.gourmetgate.gourmetgate.api.parameter;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.parameter.AbstractParameter;
import org.gourmetgate.gourmetgate.core.parameter.ParameterSerivce;
import org.gourmetgate.gourmetgate.core.parameter.ReadParameterPermission;
import org.gourmetgate.gourmetgate.core.parameter.UpdateParameterPermission;
import org.gourmetgate.gourmetgate.data.parameter.ParameterDo;

@Path("parameter")
public class ParameterResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getParameter(@PathParam("name") String name) {
    if (!ACCESS.check(new ReadParameterPermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    AbstractParameter<?> param = BEANS.get(ParameterSerivce.class).getParameterClassByName(name);
    if (param == null) {
      return m_restHelper.createNotFoundResponse();
    }
    return m_restHelper.createJsonResponse(BEANS.get(ParameterDo.class)
      .withName(name)
      .withValue(param.getRawValue()));
  }

  @PUT
  @Path("/{name}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response setParameter(@PathParam("name") String name, ParameterDo parameter) {
    if (!ACCESS.check(new UpdateParameterPermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    AbstractParameter<?> param = BEANS.get(ParameterSerivce.class).getParameterClassByName(name);
    if (param == null) {
      return m_restHelper.createNotFoundResponse();
    }
    param.setRawValue(parameter.getValue());
    return m_restHelper.createOkResponse();
  }
}
