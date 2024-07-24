package org.gourmetgate.gourmetgate.core.orderposition;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;

import java.util.stream.Stream;

public class OrderPositionService implements IService {

  public Stream<ArticleCartCountDo> getCartCounts(String orderId) {
    return BEANS.get(IOrderPositionRepository.class).getCartCountPerArticle(orderId)
      .map(pair -> BEANS.get(ArticleCartCountDo.class)
        .withArticleId(pair.getLeft())
        .withCartCount(pair.getRight()));
  }
}
