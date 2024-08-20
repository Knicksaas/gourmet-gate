package org.gourmetgate.gourmetgate.api.article;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.article.ArticleService;
import org.gourmetgate.gourmetgate.core.article.ArticleTablePagePermission;
import org.gourmetgate.gourmetgate.data.article.ArticleTablePageEntryDo;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;

@Path("article")
public class ArticleResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @GET
  @Path("tablePageData")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getArticleTablePageData() {
    if (!ACCESS.check(new ArticleTablePagePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    GenericReponse<ArticleTablePageEntryDo> response = m_restHelper.createGenericResponse(ArticleTablePageEntryDo.class);
    response.withItems(BEANS.get(ArticleService.class).getArticelTablePageData().toList());
    return m_restHelper.createJsonResponse(response);
  }
}
