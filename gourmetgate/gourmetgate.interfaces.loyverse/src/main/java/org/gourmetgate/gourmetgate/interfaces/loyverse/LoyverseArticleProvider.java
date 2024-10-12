package org.gourmetgate.gourmetgate.interfaces.loyverse;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.ArticleOptionDo;
import org.gourmetgate.gourmetgate.data.dataprovider.IArticleProvider;
import org.gourmetgate.gourmetgate.interfaces.loyverse.data.item.LoyverseItemDo;
import org.gourmetgate.gourmetgate.interfaces.loyverse.data.item.LoyverseItemVariantDo;
import org.gourmetgate.gourmetgate.interfaces.loyverse.rest.LoyverseResourceClient;

import java.util.List;

public class LoyverseArticleProvider implements IArticleProvider {

  @Override
  public List<ArticleDo> getArticles() {
    return BEANS.get(LoyverseResourceClient.class).getAllItems()
      .getItems().stream()
      .map(this::mapItemToArticle)
      .toList();
  }

  protected ArticleDo mapItemToArticle(LoyverseItemDo item) {
    LoyverseItemVariantDo firstVariant = item.getVariants().stream().findFirst().orElseThrow();

    ArticleDo article = BEANS.get(ArticleDo.class)
      .withArticleId(item.getId())
      .withArticleGroupId(item.getCategoryId())
      .withName(item.getItemName())
      .withUnit(item.getDescription())
      .withOptions(item.getVariants().size() > 1)
      .withPrice(firstVariant.getDefaultPrice())
      .withEnabled(true);

    if (article.isOptions()) {
      item.getVariants().forEach(variant -> addArticleOption(article, variant));
    }

    return article;
  }

  protected void addArticleOption(ArticleDo article, LoyverseItemVariantDo variant) {
    ArticleOptionDo option = BEANS.get(ArticleOptionDo.class)
      .withArticleOptionId(variant.getVariantId())
      .withArticleId(article.getArticleId())
      .withDescription(variant.getOption1Value());
    article.getArticleOptions().add(option);
  }
}
