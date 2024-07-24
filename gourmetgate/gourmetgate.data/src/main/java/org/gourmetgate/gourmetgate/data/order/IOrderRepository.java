package org.gourmetgate.gourmetgate.data.order;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

public interface IOrderRepository extends ICrudRepository<OrderDo> {

  String getCurrentOrderIdForSession(String sessionId);

  String getOrderForSession(String sessionId, String tableId);
}
