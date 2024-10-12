package org.gourmetgate.gourmetgate.api.article;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.ProcessingException;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.article.*;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
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

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createArticle(ArticleDo article) {
    if (!ACCESS.check(new UpdateArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    ArticleDo newArticle = BEANS.get(ArticleService.class).createArticle(article);
    GenericReponse<ArticleDo> response = m_restHelper.createGenericResponse(ArticleDo.class);
    response.withItem(newArticle);
    return m_restHelper.createJsonResponse(response);
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getArticle(@PathParam("id") String id) {
    if (!ACCESS.check(new ReadArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    ArticleDo article = BEANS.get(ArticleService.class).getArticleById(id);
    if (article == null) {
      return m_restHelper.createNotFoundResponse();
    }
    GenericReponse<ArticleDo> response = m_restHelper.createGenericResponse(ArticleDo.class);
    response.withItem(article);
    return m_restHelper.createJsonResponse(response);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateArticle(@PathParam("id") String id, ArticleDo article) {
    if (!ACCESS.check(new UpdateArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(ArticleService.class).updateArticle(id, article);
    return m_restHelper.createOkResponse();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteArticle(@PathParam("id") String id) {
    if (!ACCESS.check(new DeleteArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    int deleted = BEANS.get(ArticleService.class).deleteArticle(id);
    if (deleted == 0) {
      return m_restHelper.createNotFoundResponse();
    }
    return m_restHelper.createOkResponse();
  }

  @POST
  @Path("/sync/loyverse")
  public Response syncArticlesFromLoyverse() {
    if (!ACCESS.check(new SyncLoyversePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    try {
      BEANS.get(ArticleService.class).syncArticlesFromLoyverse();
      return m_restHelper.createOkResponse();
    } catch (ProcessingException e) {
      return m_restHelper.createInternalServerErrorResponse();
    }
  }
}
