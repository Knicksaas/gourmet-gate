package org.gourmetgate.gourmetgate.persistence.orderposition;

import org.eclipse.scout.rt.platform.util.ImmutablePair;
import org.eclipse.scout.rt.platform.util.Pair;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPosition;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionRecord;
import org.jooq.Field;
import org.jooq.impl.DSL;

import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class OrderPositionRepository extends AbstractRepository<OrderPosition, OrderPositionRecord, OrderPositionDo> implements IOrderPositionRepository {

  @Override
  public OrderPosition getTable() {
    return OrderPosition.ORDER_POSITION;
  }

  @Override
  public Field<String> getIdColumn() {
    return OrderPosition.ORDER_POSITION.ORDER_POSITION_ID;
  }

  @Override
  public Stream<Pair<String, Integer>> getCartCountPerArticle(String orderId) {
    return jooq().select(OrderPosition.ORDER_POSITION.ARTICLE_ID, DSL.count(OrderPosition.ORDER_POSITION.ARTICLE_ID))
      .from(OrderPosition.ORDER_POSITION)
      .where(OrderPosition.ORDER_POSITION.ORDER_ID.eq(orderId))
      .groupBy(OrderPosition.ORDER_POSITION.ARTICLE_ID)
      .stream()
      .map(result -> new ImmutablePair<>(result.component1(), result.component2()));
  }

  @Override
  public String getSessionIdForOrderPosition(String orderPositionId) {
    return jooq().select(Order.ORDER.SESSION_ID)
      .from(OrderPosition.ORDER_POSITION)
      .join(Order.ORDER).on(Order.ORDER.ORDER_ID.eq(OrderPosition.ORDER_POSITION.ORDER_ID))
      .where(OrderPosition.ORDER_POSITION.ORDER_POSITION_ID.eq(orderPositionId))
      .fetchOne()
      .value1();
  }

  @Override
  protected DoEntityBeanMappings<OrderPositionDo, OrderPositionRecord> mappings() {
    return new DoEntityBeanMappings<OrderPositionDo, OrderPositionRecord>()
      .with(OrderPositionDo::orderPositionId, OrderPositionRecord::getOrderPositionId, OrderPositionRecord::setOrderPositionId)
      .with(OrderPositionDo::orderId, OrderPositionRecord::getOrderId, OrderPositionRecord::setOrderId)
      .with(OrderPositionDo::articleId, OrderPositionRecord::getArticleId, OrderPositionRecord::setArticleId)
      .with(OrderPositionDo::price, OrderPositionRecord::getPrice, OrderPositionRecord::setPrice)
      .with(OrderPositionDo::vat, OrderPositionRecord::getVat, OrderPositionRecord::setVat);
  }
}
