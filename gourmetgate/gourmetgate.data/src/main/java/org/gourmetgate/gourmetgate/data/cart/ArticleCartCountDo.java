package org.gourmetgate.gourmetgate.data.cart;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("groumetgate.ArticleCartCount")
public class ArticleCartCountDo extends DoEntity {

  public DoValue<String> articleId() {
    return doValue("articleId");
  }

  public DoValue<Integer> cartCount() {
    return doValue("cartCount");
  }



  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleCartCountDo withArticleId(String articleId) {
    articleId().set(articleId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleId() {
    return articleId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleCartCountDo withCartCount(Integer cartCount) {
    cartCount().set(cartCount);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Integer getCartCount() {
    return cartCount().get();
  }
}
