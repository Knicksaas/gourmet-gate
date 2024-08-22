package org.gourmetgate.gourmetgate.core.orderposition;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.core.article.ArticleOptionService;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.ArticleOptionDo;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionDo;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;
import org.gourmetgate.gourmetgate.data.vat.IVatRepository;
import org.gourmetgate.gourmetgate.data.vat.VatDo;

import java.util.List;
import java.util.stream.Stream;

public class OrderPositionService implements IService {

  public OrderPositionDo createOrderPosition(String articleId, String orderId) {
    // Create order position
    ArticleDo article = BEANS.get(IArticleRepository.class).getById(articleId).orElseThrow();
    VatDo vat = BEANS.get(IVatRepository.class).getById(article.getVatId()).orElseThrow();
    OrderPositionDo orderPosition = BEANS.get(OrderPositionDo.class)
      .withOrderId(orderId)
      .withArticleId(articleId)
      .withPrice(article.getPrice())
      .withVat(vat.getPercent());
    return BEANS.get(IOrderPositionRepository.class).create(orderPosition);
  }

  public Stream<OrderPositionOptionDo> getOrCreateOrderPositionOptions(String orderPositionId) {
    List<OrderPositionOptionDo> options = BEANS.get(IOrderPositionOptionRepository.class).getOrderPositionsOptions(orderPositionId).toList();
    if (options.isEmpty()) {
      return createOrderPositionOptions(orderPositionId);
    } else {
      return options.stream();
    }
  }

  protected Stream<OrderPositionOptionDo> createOrderPositionOptions(String orderPositionId) {
    String articleId = BEANS.get(IOrderPositionRepository.class).getById(orderPositionId).orElseThrow().getArticleId();
    return BEANS.get(ArticleOptionService.class).getArticleOptionForArticle(articleId)
      .map(option -> fromArticleOptionToOrderOption(option, orderPositionId))
      .map(option -> BEANS.get(IOrderPositionOptionRepository.class).create(option));
  }

  protected OrderPositionOptionDo fromArticleOptionToOrderOption(ArticleOptionDo articleOption, String orderPositionId) {
    return BEANS.get(OrderPositionOptionDo.class)
      .withOrderPositionId(orderPositionId)
      .withArticleOptionId(articleOption.getArticleOptionId())
      .withSelected(false)
      .withDescription(articleOption.getDescription());
  }

  public Stream<ArticleCartCountDo> getCartCounts(String orderId) {
    return BEANS.get(IOrderPositionRepository.class).getCartCountPerArticle(orderId)
      .map(pair -> BEANS.get(ArticleCartCountDo.class)
        .withArticleId(pair.getLeft())
        .withCartCount(pair.getRight()));
  }

  public void updateOrderPositionOptions(List<OrderPositionOptionDo> items) {
    IOrderPositionOptionRepository repository = BEANS.get(IOrderPositionOptionRepository.class);
    items.forEach(option -> repository.update(option.getOrderPositionOptionId(), option));
  }

  public void deleteOrderPosition(String orderPositionId) {
    // Delete order position options
    IOrderPositionOptionRepository repo = BEANS.get(IOrderPositionOptionRepository.class);
    repo.getOrderPositionsOptions(orderPositionId)
      .map(OrderPositionOptionDo::getOrderPositionOptionId)
      .forEach(repo::delete);
    // Delete order position afterward to avoid constraint violation
    BEANS.get(IOrderPositionRepository.class).delete(orderPositionId);
  }
}
