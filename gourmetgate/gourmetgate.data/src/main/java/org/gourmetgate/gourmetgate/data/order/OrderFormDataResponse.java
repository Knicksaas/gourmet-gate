package org.gourmetgate.gourmetgate.data.order;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.OrderFormDataResponse")
public class OrderFormDataResponse extends DoEntity {

  public DoList<OrderFormDataDo> items() {
    return doList("items");
  }

  public OrderFormDataResponse withItem(OrderFormDataDo formData) {
    items().get().add(formData);
    return this;
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataResponse withItems(Collection<? extends OrderFormDataDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderFormDataResponse withItems(OrderFormDataDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<OrderFormDataDo> getItems() {
    return items().get();
  }
}
