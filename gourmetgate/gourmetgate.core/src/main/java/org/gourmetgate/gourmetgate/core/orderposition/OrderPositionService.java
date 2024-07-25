package org.gourmetgate.gourmetgate.core.orderposition;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionDo;
import org.gourmetgate.gourmetgate.data.vat.IVatRepository;
import org.gourmetgate.gourmetgate.data.vat.VatDo;

import java.util.stream.Stream;

public class OrderPositionService implements IService {

  public Stream<ArticleCartCountDo> addArticleToOrder(String articleId, String orderId) {
    // Create order position
    ArticleDo article = BEANS.get(IArticleRepository.class).getById(articleId).orElseThrow();
    VatDo vat = BEANS.get(IVatRepository.class).getById(article.getVatId()).orElseThrow();
    OrderPositionDo orderPosition = BEANS.get(OrderPositionDo.class)
      .withOrderId(orderId)
      .withArticleId(articleId)
      .withPrice(article.getPrice())
      .withVat(vat.getPercent());
    BEANS.get(IOrderPositionRepository.class).create(orderPosition);

    // Reload cart count
    return getCartCounts(orderId, articleId);
  }

  public Stream<ArticleCartCountDo> getCartCounts(String orderId) {
    return getCartCounts(orderId, null);
  }

  public Stream<ArticleCartCountDo> getCartCounts(String orderId, String articleId) {
    return BEANS.get(IOrderPositionRepository.class).getCartCountPerArticle(orderId, articleId)
      .map(pair -> BEANS.get(ArticleCartCountDo.class)
        .withArticleId(pair.getLeft())
        .withCartCount(pair.getRight()));
  }
}
