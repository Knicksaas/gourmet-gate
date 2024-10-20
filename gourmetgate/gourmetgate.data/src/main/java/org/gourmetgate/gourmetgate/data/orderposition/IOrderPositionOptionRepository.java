package org.gourmetgate.gourmetgate.data.orderposition;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.stream.Stream;

public interface IOrderPositionOptionRepository extends ICrudRepository<OrderPositionOptionDo> {

  Stream<OrderPositionOptionDo> getOrderPositionsOptions(String orderPositionId);

  Stream<String> getSelectedOrderPositionOptionNames(String orderPositionId);
}
