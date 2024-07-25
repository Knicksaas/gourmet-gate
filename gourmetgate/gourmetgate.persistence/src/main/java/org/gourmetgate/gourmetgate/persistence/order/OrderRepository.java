package org.gourmetgate.gourmetgate.persistence.order;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.order.OrderDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderRecord;
import org.jooq.Field;
import org.jooq.Record1;

import java.util.Date;
import java.util.Optional;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class OrderRepository extends AbstractRepository<Order, OrderRecord, OrderDo> implements IOrderRepository {

  @Override
  public Order getTable() {
    return Order.ORDER;
  }

  @Override
  public Field<String> getIdColumn() {
    return Order.ORDER.ORDER_ID;
  }

  @Override
  public String getCurrentOrderIdForSession(String sessionId) {
    Optional<Record1<String>> orderId = Optional.ofNullable(
      jooq().select(Order.ORDER.ORDER_ID)
        .from(Order.ORDER)
        .where(Order.ORDER.EVT_PAY.isNull())
        .and(Order.ORDER.SESSION_ID.eq(sessionId))
        .fetchOne());
    return orderId.map(Record1::component1).orElse(null);
  }

  @Override
  public String getOrCreateOrderForSession(String sessionId, String tableId) {
    String currentOrder = getCurrentOrderIdForSession(sessionId);
    if (currentOrder != null) {
      return currentOrder;
    }
    OrderDo orderDo = BEANS.get(OrderDo.class)
      .withTableId(tableId)
      .withSessionId(sessionId)
      .withEvtCreate(new Date())
      .withStatus("ACTIVE");
    return create(orderDo).getOrderId();
  }

  @Override
  protected DoEntityBeanMappings<OrderDo, OrderRecord> mappings() {
    return new DoEntityBeanMappings<OrderDo, OrderRecord>()
      .with(OrderDo::orderId, OrderRecord::getOrderId, OrderRecord::setOrderId)
      .with(OrderDo::tableId, OrderRecord::getTableId, OrderRecord::setTableId)
      .with(OrderDo::sessionId, OrderRecord::getSessionId, OrderRecord::setSessionId)
      .with(OrderDo::status, OrderRecord::getStatus, OrderRecord::setStatus)
      .with(OrderDo::tip, OrderRecord::getTip, OrderRecord::setTip)
      .with(OrderDo::evtCreate, OrderRecord::getEvtCreate, OrderRecord::setEvtCreate)
      .with(OrderDo::evtPay, OrderRecord::getEvtPay, OrderRecord::setEvtPay);
  }
}
