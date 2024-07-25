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

  public DoList<ArticleCartCountDo> items() {
    return doList("items");
  }

  public OrderPositionResponse withItem(ArticleCartCountDo cartCountDos) {
    items().get().add(cartCountDos);
    return this;
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withItems(Collection<? extends ArticleCartCountDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionResponse withItems(ArticleCartCountDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ArticleCartCountDo> getItems() {
    return items().get();
  }
}
