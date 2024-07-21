package org.gourmetgate.gourmetgate.data.article;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@TypeName("gourmetgate.PersonResponse")
public class ArticleResponse extends DoEntity {

  public DoList<ArticleDo> items() {
    return doList("items");
  }

  public ArticleResponse withItem(ArticleDo article) {
    items().get().add(article);
    return this;
  }

  public ArticleResponse withItems(Stream<ArticleDo> articles) {
    items().clear();
    List<ArticleDo> articleDo = items().get();
    articles.forEachOrdered(articleDo::add);
    return this;
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleResponse withItems(Collection<? extends ArticleDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleResponse withItems(ArticleDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleDo> getItems() {
    return items().get();
  }
}
