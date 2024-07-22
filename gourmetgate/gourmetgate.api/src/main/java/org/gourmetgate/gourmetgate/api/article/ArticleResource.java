package org.gourmetgate.gourmetgate.api.article;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;
import org.gourmetgate.gourmetgate.core.article.ArticleService;
import org.gourmetgate.gourmetgate.data.article.ArticleResponse;

@Path("article")
public class ArticleResource implements IRestResource {

  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public ArticleResponse all() {
    return BEANS.get(ArticleResponse.class)
      .withItems(BEANS.get(ArticleService.class).all());
  }
}
