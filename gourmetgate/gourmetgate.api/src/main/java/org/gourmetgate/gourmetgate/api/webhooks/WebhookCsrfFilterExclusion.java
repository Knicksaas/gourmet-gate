package org.gourmetgate.gourmetgate.api.webhooks;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.container.ContainerRequestContext;
import org.eclipse.scout.rt.rest.csrf.IAntiCsrfFilterExclusion;

public class WebhookCsrfFilterExclusion implements IAntiCsrfFilterExclusion {

  @Override
  public boolean isIgnored(ContainerRequestContext requestContext) {
    return requestContext.getUriInfo().getPath().startsWith(getConfiguredExcludedRoute());
  }

  @Override
  public boolean isIgnored(ClientRequestContext requestContext) {
    return requestContext.getUri().getPath().startsWith(getConfiguredExcludedRoute());
  }

  protected String getConfiguredExcludedRoute() {
    return "webhook/";
  }
}

