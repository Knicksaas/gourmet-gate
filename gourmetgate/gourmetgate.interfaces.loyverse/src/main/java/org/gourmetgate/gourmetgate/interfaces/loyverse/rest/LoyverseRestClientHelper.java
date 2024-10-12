package org.gourmetgate.gourmetgate.interfaces.loyverse.rest;

import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.client.AbstractRestClientHelper;
import org.gourmetgate.gourmetgate.core.LoyverseBearerTokenParameter;

@ApplicationScoped
public class LoyverseRestClientHelper extends AbstractRestClientHelper {

  public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

  @Override
  protected String getBaseUri() {
    return "https://api.loyverse.com/";
  }

  @Override
  protected RuntimeException transformException(RuntimeException e, Response response) {
    return new ProcessingException("Error while accessing Loyverse API", e);
  }

  protected MultivaluedMap<String, Object> getAuthorisationHeader() {
    MultivaluedMap<String, Object> headerMap = new MultivaluedHashMap<>();
    headerMap.add("Authorization", "Bearer " + BEANS.get(LoyverseBearerTokenParameter.class).getValue());
    return headerMap;
  }
}
