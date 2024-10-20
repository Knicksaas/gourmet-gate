package org.gourmetgate.gourmetgate.persistence.orderposition;

import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionOptionRecord;
import org.jooq.Field;
import org.jooq.Record1;

import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

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
  public Stream<OrderPositionOptionDo> getOrderPositionsOptions(String orderPositionId) {
    return jooq()
      .selectFrom(getTable())
      .where(getTable().ORDER_POSITION_ID.eq(orderPositionId))
      .stream()
      .map(this::fromRecordToDo);
  }

  @Override
  public Stream<String> getSelectedOrderPositionOptionNames(String orderPositionId) {
    return jooq()
      .select(
        ArticleOption.ARTICLE_OPTION.DESCRIPTION)
      .from(getTable())
      .join(ArticleOption.ARTICLE_OPTION).on(OrderPositionOption.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID.eq(ArticleOption.ARTICLE_OPTION.ARTICLE_OPTION_ID))
      .where(OrderPositionOption.ORDER_POSITION_OPTION.SELECTED)
      .and(OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_ID.eq(orderPositionId))
      .stream()
      .map(Record1::component1);
  }

  @Override
  protected DoEntityBeanMappings<OrderPositionOptionDo, OrderPositionOptionRecord> mappings() {
    return new DoEntityBeanMappings<OrderPositionOptionDo, OrderPositionOptionRecord>()
      .with(OrderPositionOptionDo::orderPositionOptionId, OrderPositionOptionRecord::getOrderPositionOptionId, OrderPositionOptionRecord::setOrderPositionOptionId)
      .with(OrderPositionOptionDo::orderPositionId, OrderPositionOptionRecord::getOrderPositionId, OrderPositionOptionRecord::setOrderPositionId)
      .with(OrderPositionOptionDo::articleOptionId, OrderPositionOptionRecord::getArticleOptionId, OrderPositionOptionRecord::setArticleOptionId)
      .with(OrderPositionOptionDo::selected, OrderPositionOptionRecord::getSelected, OrderPositionOptionRecord::setSelected)
      .with(OrderPositionOptionDo::description, OrderPositionOptionRecord::getDescription, OrderPositionOptionRecord::setDescription);
  }
}
