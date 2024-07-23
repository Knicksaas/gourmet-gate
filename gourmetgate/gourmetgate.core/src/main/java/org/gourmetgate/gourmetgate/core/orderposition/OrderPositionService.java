package org.gourmetgate.gourmetgate.core.orderposition;

import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;

import java.util.stream.Stream;

public class OrderPositionService implements IService {

  public Stream<ArticleCartCountDo> getCartCounts(String orderId) {
    return Stream.empty();
  }
}
