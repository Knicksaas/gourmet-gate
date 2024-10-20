package org.gourmetgate.gourmetgate.data.order;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.printable.PrintableOrderDo;

import java.util.List;
import java.util.stream.Stream;

public interface IOrderRepository extends ICrudRepository<OrderDo> {

  String getCurrentOrderIdForSession(String sessionId);

  String getOrderIdForSessionWithoutFilter(String sessionId);

  String createOrder(String sessionId, String tableId);

  int getOpenOrdersForTable(String tableId);

  Stream<PrintableOrderDo> getUnprintedOrders();

  int markOrdersAsPrinted(List<String> orderIds);
}
