package org.gourmetgate.gourmetgate.persistence.orderposition;

import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionOptionRecord;
import org.jooq.Field;

public class OrderPositionOptionRepository extends AbstractRepository<OrderPositionOption, OrderPositionOptionRecord, OrderPositionOptionDo> implements IOrderPositionOptionRepository {

  @Override
  public OrderPositionOption getTable() {
    return OrderPositionOption.ORDER_POSITION_OPTION;
  }

  @Override
  public Field<String> getIdColumn() {
    return OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID;
  }

  @Override
  protected DoEntityBeanMappings<OrderPositionOptionDo, OrderPositionOptionRecord> mappings() {
    return new DoEntityBeanMappings<OrderPositionOptionDo, OrderPositionOptionRecord>()
      .with(OrderPositionOptionDo::orderPositionOptionId, OrderPositionOptionRecord::getOrderPositionOptionId, OrderPositionOptionRecord::setOrderPositionOptionId)
      .with(OrderPositionOptionDo::orderPositionId, OrderPositionOptionRecord::getOrderPositionId, OrderPositionOptionRecord::setOrderPositionId)
      .with(OrderPositionOptionDo::articleOptionId, OrderPositionOptionRecord::getArticleOptionId, OrderPositionOptionRecord::setArticleOptionId)
      .with(OrderPositionOptionDo::selected, OrderPositionOptionRecord::getSelected, OrderPositionOptionRecord::setSelected);
  }
}
