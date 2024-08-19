package org.gourmetgate.gourmetgate.api;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.server.commons.authentication.AnonymousAccessController;
import org.eclipse.scout.rt.server.commons.authentication.FormBasedAccessController;
import org.eclipse.scout.rt.server.commons.authentication.TrivialAccessController;

import java.io.IOException;

/**
 * <h3>{@link RestAuthFilter}</h3>
 */
public class RestAuthFilter implements Filter {

  private TrivialAccessController m_trivialAccessController;
  private FormBasedAccessController m_formBasedAccessController;
  private AnonymousAccessController m_anonymousAccessController;

  @Override
  public void init(FilterConfig filterConfig) {
    m_trivialAccessController = BEANS.get(TrivialAccessController.class)
      .init(new TrivialAccessController.TrivialAuthConfig()
        .withExclusionFilter(filterConfig.getInitParameter("filter-exclude"))
        .withLoginPageInstalled(true));
    m_formBasedAccessController = BEANS.get(FormBasedAccessController.class)
      .init(new FormBasedAccessController.FormBasedAuthConfig()
        .withCredentialVerifier(BEANS.get(GourmetGateCredentialVerifyer.class)));
    m_anonymousAccessController = BEANS.get(AnonymousAccessController.class).init();
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    final HttpServletRequest req = (HttpServletRequest) request;
    final HttpServletResponse resp = (HttpServletResponse) response;

    if (m_trivialAccessController.handle(req, resp, chain)) {
      return;
    }

    if (m_formBasedAccessController.handle(req, resp, chain)) {
      return;
    }

    if (m_anonymousAccessController.handle(req, resp, chain)) {
      return;
    }

    resp.sendError(HttpServletResponse.SC_FORBIDDEN);
  }

  @Override
  public void destroy() {
    m_formBasedAccessController.destroy();
    m_anonymousAccessController.destroy();
  }
}
