package org.gourmetgate.gourmetgate.data.articlegroup;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.ArticleGroup")
public class ArticleGroupDo extends DoEntity {

  public DoValue<String> articleGroupId() {
    return doValue("articleGroupId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> status() {
    return doValue("status");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleGroupDo withArticleGroupId(String articleGroupId) {
    articleGroupId().set(articleGroupId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleGroupId() {
    return articleGroupId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleGroupDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleGroupDo withStatus(String status) {
    status().set(status);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getStatus() {
    return status().get();
  }
}
