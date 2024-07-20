package org.gourmetgate.gourmetgate.persistence.order;

import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.order.OrderDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderRecord;
import org.jooq.Field;

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
  protected DoEntityBeanMappings<OrderDo, OrderRecord> mappings() {
    return new DoEntityBeanMappings<OrderDo, OrderRecord>()
      .with(OrderDo::orderId, OrderRecord::getOrderId, OrderRecord::setOrderId)
      .with(OrderDo::tableId, OrderRecord::getTableId, OrderRecord::setTableId)
      .with(OrderDo::status, OrderRecord::getStatus, OrderRecord::setStatus)
      .with(OrderDo::tip, OrderRecord::getTip, OrderRecord::setTip)
      .with(OrderDo::evtCreate, OrderRecord::getEvtCreate, OrderRecord::setEvtCreate)
      .with(OrderDo::evtPay, OrderRecord::getEvtPay, OrderRecord::setEvtPay);
  }
}
