package org.gourmetgate.gourmetgate.api;

import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.IDataObjectMapper;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@ApplicationScoped
public class RestHelper {

  public boolean checkAccessToOrderPosition(String jsessionId, String orderPositionId) {
    String belongingSession = BEANS.get(IOrderPositionRepository.class).getSessionIdForOrderPosition(orderPositionId);
    return belongingSession.equals(jsessionId);
  }

  public Response createOkResponse() {
    return Response.ok().build();
  }

  public Response createOkResponse(Object entity) {
    return Response.ok(entity).build();
  }

  public Response createJsonResponse(DoEntity dataObject) {
    return createOkResponse(BEANS.get(IDataObjectMapper.class).writeValue(dataObject));
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

  public <T extends DoEntity> Response createGenericJsonResponse(T dataObject) {
    return createGenericJsonResponse(CollectionUtility.arrayList(dataObject));
  }

  @SuppressWarnings("unchecked")
  public <T extends DoEntity> Response createGenericJsonResponse(List<T> dataObjects) {
    Class<T> doClass = (Class<T>) dataObjects.stream().findAny().map(Object::getClass).orElse(null);
    if (doClass == null) {
      doClass = (Class<T>) DoEntity.class;
    }
    GenericReponse<T> genericReponse = createGenericResponse(doClass);
    genericReponse.withItems(dataObjects);
    return createJsonResponse(genericReponse);
  }

  public Response createTemoraryJsRedirectResponse(String url) {
    try {
      return Response.status(Response.Status.NOT_ACCEPTABLE).location(new URI(url)).build();
    } catch (URISyntaxException e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  public Response createTemoraryServerRedirectResponse(String url) {
    try {
      return Response.status(Response.Status.FOUND).location(new URI(url)).build();
    } catch (URISyntaxException e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  public Response createInternalServerErrorResponse() {
    return Response.serverError().build();
  }
}
