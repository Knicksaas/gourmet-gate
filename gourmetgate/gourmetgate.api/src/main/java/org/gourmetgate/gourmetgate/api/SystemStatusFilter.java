package org.gourmetgate.gourmetgate.api;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.context.RunContext;
import org.gourmetgate.gourmetgate.core.application.ApplicationService;
import org.gourmetgate.gourmetgate.data.application.ApplicationStatus;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * <h3>{@link SystemStatusFilter}</h3>
 */
public class SystemStatusFilter implements Filter {

  private ApplicationService m_service;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    m_service = BEANS.get(ApplicationService.class);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    final HttpServletResponse resp = (HttpServletResponse) response;

    if (getExclusionFilters().contains(((HttpServletRequest) request).getRequestURI())) {
      chain.doFilter(request, response);
      return;
    }

    Principal principal = RunContext.CURRENT.get().getSubject().getPrincipals().stream().findAny().orElse(null);
    if (principal != null && !principal.getName().equalsIgnoreCase("anonymous")) {
      // No filtering when user is authenticated
      chain.doFilter(request, response);
      return;
    }

    if (m_service.getApplicationStatus() == ApplicationStatus.PAUSED) {
      resp.setHeader("location", "../#pause");
      resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
      return;
    }
    chain.doFilter(request, response);
  }

  public List<String> getExclusionFilters() {
    return List.of("/api/permissions");
  }
}
