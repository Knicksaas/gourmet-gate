package org.gourmetgate.gourmetgate.persistence.orderposition;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.article.IArticleOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionOptionRecord;
import org.jooq.Field;

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
      .select(
        getTable().ORDER_POSITION_OPTION_ID,
        getTable().ORDER_POSITION_ID,
        getTable().ARTICLE_OPTION_ID,
        getTable().SELECTED,
        ArticleOption.ARTICLE_OPTION.DESCRIPTION)
      .from(getTable())
      .join(ArticleOption.ARTICLE_OPTION).on(ArticleOption.ARTICLE_OPTION.ARTICLE_OPTION_ID.eq(getTable().ARTICLE_OPTION_ID))
      .where(getTable().ORDER_POSITION_ID.eq(orderPositionId))
      .stream()
      .map(rec -> BEANS.get(OrderPositionOptionDo.class)
        .withOrderPositionOptionId(rec.component1())
        .withOrderPositionId(rec.component2())
        .withArticleOptionId(rec.component3())
        .withSelected(rec.component4())
        .withDescription(rec.component5()));
  }

  @Override
  public Stream<OrderPositionOptionDo> createOrderPositionsFromOptions(String orderPositionId) {
    String articleId = BEANS.get(IOrderPositionRepository.class).getById(orderPositionId).orElseThrow().getArticleId();
    BEANS.get(IArticleOptionRepository.class)
      .getArticleOptionsForArticle(articleId)
      .map(articleOptionDo -> BEANS.get(OrderPositionOptionDo.class)
        .withOrderPositionId(orderPositionId)
        .withArticleOptionId(articleOptionDo.getArticleOptionId())
        .withSelected(false))
      .forEach(this::create);
    return getOrderPositionsOptions(orderPositionId);
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
