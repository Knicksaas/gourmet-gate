package org.gourmetgate.gourmetgate.data.order;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.OrderFormData")
public class OrderFormDataDo extends DoEntity {

  public DoList<ArticleDo> articles() {
    return doList("articles");
  }

  public DoList<ArticleGroupDo> articleGroups() {
    return doList("articleGroups");
  }

  public DoList<ArticleCartCountDo> cartCounts() {
    return doList("articleCartCounts");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withArticles(Collection<? extends ArticleDo> articles) {
    articles().updateAll(articles);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withArticles(ArticleDo... articles) {
    articles().updateAll(articles);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleDo> getArticles() {
    return articles().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withArticleGroups(Collection<? extends ArticleGroupDo> articleGroups) {
    articleGroups().updateAll(articleGroups);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withArticleGroups(ArticleGroupDo... articleGroups) {
    articleGroups().updateAll(articleGroups);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleGroupDo> getArticleGroups() {
    return articleGroups().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withCartCounts(Collection<? extends ArticleCartCountDo> cartCounts) {
    cartCounts().updateAll(cartCounts);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataDo withCartCounts(ArticleCartCountDo... cartCounts) {
    cartCounts().updateAll(cartCounts);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleCartCountDo> getCartCounts() {
    return cartCounts().get();
  }
}
