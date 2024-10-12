package org.gourmetgate.gourmetgate.interfaces.loyverse.data.item;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;

import java.util.Collection;
import java.util.List;

public class LoyverseItemResponseDo extends DoEntity {

  public DoList<LoyverseItemDo> items() {
    return doList("items");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemResponseDo withItems(Collection<? extends LoyverseItemDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemResponseDo withItems(LoyverseItemDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<LoyverseItemDo> getItems() {
    return items().get();
  }
}
