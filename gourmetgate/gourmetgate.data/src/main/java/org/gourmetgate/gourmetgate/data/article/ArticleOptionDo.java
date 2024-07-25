package org.gourmetgate.gourmetgate.data.article;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

public class ArticleOptionDo extends DoEntity {

  public DoValue<String> articleOptionId() {
    return doValue("articleOptionId");
  }

  public DoValue<String> articleId() {
    return doValue("articleId");
  }

  public DoValue<String> description() {
    return doValue("description");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleOptionDo withArticleOptionId(String articleOptionId) {
    articleOptionId().set(articleOptionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleOptionId() {
    return articleOptionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleOptionDo withArticleId(String articleId) {
    articleId().set(articleId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleId() {
    return articleId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleOptionDo withDescription(String description) {
    description().set(description);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }
}
