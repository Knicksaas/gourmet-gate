package org.gourmetgate.gourmetgate.api.article;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.eclipse.scout.rt.security.ACCESS;
import org.gourmetgate.gourmetgate.api.RestHelper;
import org.gourmetgate.gourmetgate.core.article.ArticleGroupService;
import org.gourmetgate.gourmetgate.core.article.DeleteArticlePermission;
import org.gourmetgate.gourmetgate.core.article.ReadArticlePermission;
import org.gourmetgate.gourmetgate.core.article.UpdateArticlePermission;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.common.GenericReponse;
import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupResultDo;

@Path("article/group")
public class ArticleGroupResource implements IRestResource {

  private RestHelper m_restHelper;

  @PostConstruct
  public void init() {
    m_restHelper = BEANS.get(RestHelper.class);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createArticleGroup(ArticleGroupDo articleGroupDo) {
    if (!ACCESS.check(new UpdateArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    ArticleGroupDo newArticleGroup = BEANS.get(ArticleGroupService.class).createArticleGroup(articleGroupDo);
    GenericReponse<ArticleGroupDo> response = m_restHelper.createGenericResponse(ArticleGroupDo.class);
    response.withItem(newArticleGroup);
    return m_restHelper.createJsonResponse(response);
  }

  @GET
  @Path("/{id}")
  public Response getArticleGroup(@PathParam("id") String articleGroupId) {
    if (!ACCESS.check(new ReadArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    return BEANS.get(ArticleGroupService.class).getArticleGroup(articleGroupId)
      .map(articleGroupDo -> m_restHelper.createGenericResponse(ArticleGroupDo.class).withItem(articleGroupDo))
      .map(m_restHelper::createJsonResponse)
      .orElseGet(m_restHelper::createNotFoundResponse);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateArticleGroup(@PathParam("id") String articleGroupId, ArticleGroupDo articleGroupDo) {
    if (!ACCESS.check(new UpdateArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    BEANS.get(ArticleGroupService.class).updateArticleGroup(articleGroupId, articleGroupDo);
    return m_restHelper.createOkResponse();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteArticleGroup(@PathParam("id") String articleGroupId) {
    if (!ACCESS.check(new DeleteArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    boolean success = BEANS.get(ArticleGroupService.class).deleteArticleGroup(articleGroupId);
    if (success) {
      return m_restHelper.createOkResponse();
    } else {
      return m_restHelper.createNotFoundResponse();
    }
  }

  @POST
  @Path("lookup")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response postLookupArticleGroup(LookupRestrictionDo restriction) {
    if (!ACCESS.check(new ReadArticlePermission())) {
      return m_restHelper.createForbiddenResponse();
    }

    LookupResultDo result = BEANS.get(ArticleGroupService.class).lookupArticleGroup(restriction);
    return m_restHelper.createJsonResponse(result);
  }
}
