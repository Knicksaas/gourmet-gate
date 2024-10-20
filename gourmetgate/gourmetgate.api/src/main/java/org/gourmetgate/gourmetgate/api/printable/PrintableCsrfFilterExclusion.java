package org.gourmetgate.gourmetgate.api.printable;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.container.ContainerRequestContext;
import org.eclipse.scout.rt.rest.csrf.IAntiCsrfFilterExclusion;

public class PrintableCsrfFilterExclusion implements IAntiCsrfFilterExclusion {

  @Override
  public boolean isIgnored(ContainerRequestContext requestContext) {
    return requestContext.getUriInfo().getPath().startsWith(getConfiguredExcludedRoute());
  }

  @Override
  public boolean isIgnored(ClientRequestContext requestContext) {
    return requestContext.getUri().getPath().startsWith(getConfiguredExcludedRoute());
  }

  protected String getConfiguredExcludedRoute() {
    return "printable/orders";
  }
}

