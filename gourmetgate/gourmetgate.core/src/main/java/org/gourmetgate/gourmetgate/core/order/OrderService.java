package org.gourmetgate.gourmetgate.core.order;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.core.article.ArticleGroupService;
import org.gourmetgate.gourmetgate.core.article.ArticleService;
import org.gourmetgate.gourmetgate.core.orderposition.OrderPositionService;
import org.gourmetgate.gourmetgate.core.table.TableService;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.common.EntityType;
import org.gourmetgate.gourmetgate.data.eventlog.EventLogger;
import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.order.OrderFormDataDo;

import java.util.List;

public class OrderService implements IService {

  private final EventLogger m_eventLogger = BEANS.get(EventLogger.class).withEntityType(EntityType.ORDER);

  public OrderFormDataDo getOrderFormData(String orderId) {
    OrderFormDataDo formData = BEANS.get(OrderFormDataDo.class);
    List<ArticleGroupDo> articleGroups = BEANS.get(ArticleGroupService.class).allEnabled().toList();
    List<ArticleDo> articles = BEANS.get(ArticleService.class).allEnabled()
      .filter(articleDo -> articleGroups.stream()
        .map(ArticleGroupDo::getArticleGroupId)
        .anyMatch(id -> id.equals(articleDo.getArticleGroupId())))
      .toList();

    formData.withArticleGroups(articleGroups);
    formData.withArticles(articles);
    formData.withCartCounts(BEANS.get(OrderPositionService.class).getCartCounts(orderId).toList());
    return formData;
  }

  public String getOrderIdForSession(String sessionId) {
    return BEANS.get(IOrderRepository.class).getCurrentOrderIdForSession(sessionId);
  }

  public String getOrderIdForSessionWithoutFilter(String sessionId) {
    return BEANS.get(IOrderRepository.class).getOrderIdForSessionWithoutFilter(sessionId);
  }

  public void getOrCreateOrderForSession(String sessionId, String tableId) {
    if (getOrderIdForSession(sessionId) != null) {
      return;
    }
    String orderId = BEANS.get(IOrderRepository.class).createOrder(sessionId, tableId);
    String tableName = BEANS.get(TableService.class).getTableName(tableId);
    m_eventLogger.logCreatedEvent(orderId, String.format("Created new order for table %s", tableName));
  }

  public int getOpenOrderCountForTable(String tableId) {
    return BEANS.get(IOrderRepository.class).getOpenOrdersForTable(tableId);
  }
}
