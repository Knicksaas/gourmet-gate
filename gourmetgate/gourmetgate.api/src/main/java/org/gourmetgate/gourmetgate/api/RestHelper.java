package org.gourmetgate.gourmetgate.api;

import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.IDataObjectMapper;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;

@ApplicationScoped
public class RestHelper {

  public boolean checkAccessToOrderPosition(String jsessionId, String orderPositionId) {
    String belongingSession = BEANS.get(IOrderPositionRepository.class).getSessionIdForOrderPosition(orderPositionId);
    return belongingSession.equals(jsessionId);
  }

  public Response createOkResponse() {
    return Response.ok().build();
  }

  public Response createJsonResponse(DoEntity dataObject) {
    return Response.ok(BEANS.get(IDataObjectMapper.class).writeValue(dataObject)).build();
  }

  public Response createNotFoundResponse() {
    return Response.status(Response.Status.NOT_FOUND).build();
  }

  public Response createForbiddenResponse() {
    return Response.status(Response.Status.FORBIDDEN).build();
  }

  public Response createBadRequestResponse(String message) {
    return Response.status(Response.Status.BAD_REQUEST)
      .entity(message)
      .build();
  }

  @SuppressWarnings("unchecked")
  public <T extends DoEntity> GenericReponse<T> createGenericResponse(Class<T> typeClass) {
    return BEANS.get(GenericReponse.class);
  }
}
