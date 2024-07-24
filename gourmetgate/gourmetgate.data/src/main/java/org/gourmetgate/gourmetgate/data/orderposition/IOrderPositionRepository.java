package org.gourmetgate.gourmetgate.data.orderposition;

import org.eclipse.scout.rt.platform.util.Pair;
import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.stream.Stream;

public interface IOrderPositionRepository extends ICrudRepository<OrderPositionDo> {

  Stream<Pair<String, Integer>> getCartCountPerArticle(String orderId);
}
