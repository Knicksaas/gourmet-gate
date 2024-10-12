package org.gourmetgate.gourmetgate.interfaces.loyverse.data.category;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;

import java.util.Collection;
import java.util.List;

public class LoyverseCategoryResponseDo extends DoEntity {

  public DoList<LoyverseCategoryDo> categories() {
    return doList("categories");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryResponseDo withCategories(Collection<? extends LoyverseCategoryDo> categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryResponseDo withCategories(LoyverseCategoryDo... categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<LoyverseCategoryDo> getCategories() {
    return categories().get();
  }
}
