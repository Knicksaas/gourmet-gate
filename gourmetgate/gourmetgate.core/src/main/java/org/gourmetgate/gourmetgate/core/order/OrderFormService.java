package org.gourmetgate.gourmetgate.core.order;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.core.article.ArticleService;
import org.gourmetgate.gourmetgate.core.articlegroup.ArticleGroupService;
import org.gourmetgate.gourmetgate.core.orderposition.OrderPositionService;
import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.order.OrderFormDataDo;

public class OrderFormService implements IService {

  public OrderFormDataDo getOrderFormData(String orderId) {
    OrderFormDataDo formData = BEANS.get(OrderFormDataDo.class);
    formData.withArticleGroups(BEANS.get(ArticleGroupService.class).all().toList());
    formData.withArticles(BEANS.get(ArticleService.class).all().toList());
    formData.withCartCounts(BEANS.get(OrderPositionService.class).getCartCounts(orderId).toList());
    return formData;
  }

  public String getOrderIdForSession(String sessionId, String tableId) {
    return BEANS.get(IOrderRepository.class).getOrderForSession(sessionId, tableId);
  }
}
