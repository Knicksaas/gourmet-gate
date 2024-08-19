package org.gourmetgate.gourmetgate.app;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.scout.rt.jetty.IServletContributor;
import org.eclipse.scout.rt.jetty.IServletFilterContributor;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.Replace;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.rest.RestApplication;
import org.eclipse.scout.rt.server.context.HttpServerRunContextFilter;
import org.eclipse.scout.rt.ui.html.app.UiServletContributors;
import org.eclipse.scout.rt.ui.html.app.UiServletContributors.GzipFilterContributor;
import org.eclipse.scout.rt.ui.html.app.UiServletContributors.UiServletContributor;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.gourmetgate.gourmetgate.api.RestAuthFilter;

import java.util.Arrays;
import java.util.List;

/**
 * {@link IServletContributor} and {@link IServletFilterContributor} for app.
 */
public final class AppServletContributors {

  private AppServletContributors() {
  }

  @Replace
  public static class AuthFilterContributor extends UiServletContributors.AuthFilterContributor {

    @Override
    public void contribute(ServletContextHandler handler) {
      FilterHolder filter = handler.addFilter(RestAuthFilter.class, "/*", null);
      filter.setInitParameter("filter-exclude", StringUtility.join("\n", getFilterExcludes()));
    }

    @Override
    protected List<String> getFilterExcludes() {
      List<String> filterExcludes = super.getFilterExcludes();
      filterExcludes.addAll(Arrays.asList(
        "/favicon/*",
        "/fonts/*",
        "/logo.png",
        "sucess.html",
        "failed.html",
        "/*login*.js",
        "/*logout*.js",
        "/*frwdeluxe-theme*.css"));
      return filterExcludes;
    }
  }

  /**
   * Filters for API access.
   * <p>
   * After {@link GzipFilterContributor}.
   */
  @Order(4000)
  public static class RestAuthFilterContributor implements IServletFilterContributor {

    @Override
    public void contribute(ServletContextHandler handler) {
      handler.addFilter(RestAuthFilter.class, "/api/*", null);
    }
  }

  @Order(5000)
  public static class ApiServerRunContextFilterContributor implements IServletFilterContributor {

    @Override
    public void contribute(ServletContextHandler handler) {
      FilterHolder filter = handler.addFilter(HttpServerRunContextFilter.class, "/api/*", null);
      filter.setInitParameter("session", "false");
    }
  }

  /**
   * JAX-RS Jersey Servlet.
   * <p>
   * After {@link UiServletContributor}.
   */
  @Order(3000)
  public static class ApiServletContributor implements IServletContributor {

    @Override
    public void contribute(ServletContextHandler handler) {
      ServletHolder servlet = handler.addServlet(ServletContainer.class, "/api/*");
      servlet.setInitParameter(ServerProperties.WADL_FEATURE_DISABLE, Boolean.TRUE.toString());
      servlet.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, RestApplication.class.getName());
      servlet.setInitOrder(1); // load-on-startup
    }
  }
}
