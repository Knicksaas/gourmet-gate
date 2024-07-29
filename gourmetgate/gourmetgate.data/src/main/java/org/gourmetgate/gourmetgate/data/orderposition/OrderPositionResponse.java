package org.gourmetgate.gourmetgate.data.orderposition;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;
import org.gourmetgate.gourmetgate.data.cart.ArticleCartCountDo;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.OrderPositionResponse")
public class OrderPositionResponse extends DoEntity {

  public DoList<ArticleCartCountDo> cartCounts() {
    return doList("cartCounts");
  }

  public DoList<OrderPositionOptionDo> orderPositionOptions() {
    return doList("orderPositionOptions");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withCartCounts(Collection<? extends ArticleCartCountDo> cartCounts) {
    cartCounts().updateAll(cartCounts);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withCartCounts(ArticleCartCountDo... cartCounts) {
    cartCounts().updateAll(cartCounts);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleCartCountDo> getCartCounts() {
    return cartCounts().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withOrderPositionOptions(Collection<? extends OrderPositionOptionDo> orderPositionOptions) {
    orderPositionOptions().updateAll(orderPositionOptions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withOrderPositionOptions(OrderPositionOptionDo... orderPositionOptions) {
    orderPositionOptions().updateAll(orderPositionOptions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<OrderPositionOptionDo> getOrderPositionOptions() {
    return orderPositionOptions().get();
  }
}
