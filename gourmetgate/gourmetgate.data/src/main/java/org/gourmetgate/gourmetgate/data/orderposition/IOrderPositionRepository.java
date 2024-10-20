package org.gourmetgate.gourmetgate.data.orderposition;

import org.eclipse.scout.rt.platform.util.Pair;
import org.gourmetgate.gourmetgate.data.cart.CartItemDo;
import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.printable.PrintableOrderPositionDo;

import java.util.stream.Stream;

public interface IOrderPositionRepository extends ICrudRepository<OrderPositionDo> {

  Stream<Pair<String, Integer>> getCartCountPerArticle(String orderId);

  String getSessionIdForOrderPosition(String orderPositionId);

  Stream<CartItemDo> getCartItemsByOrderId(String orderId);

  Stream<PrintableOrderPositionDo> getPrintableOrderPositionsByOrderId(String orderId);
}
