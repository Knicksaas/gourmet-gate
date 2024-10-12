package org.gourmetgate.gourmetgate.interfaces.loyverse.data.item;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.Collection;
import java.util.List;

public class LoyverseItemDo extends DoEntity {

  public DoValue<String> id() {
    return doValue("id");
  }

  public DoValue<String> itemName() {
    return doValue("item_name");
  }

  public DoValue<String> description() {
    return doValue("description");
  }

  public DoValue<String> categoryId() {
    return doValue("category_id");
  }

  public DoList<LoyverseItemVariantDo> variants() {
    return doList("variants");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withId(String id) {
    id().set(id);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getId() {
    return id().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withItemName(String itemName) {
    itemName().set(itemName);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getItemName() {
    return itemName().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withDescription(String description) {
    description().set(description);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withCategoryId(String categoryId) {
    categoryId().set(categoryId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getCategoryId() {
    return categoryId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withVariants(Collection<? extends LoyverseItemVariantDo> variants) {
    variants().updateAll(variants);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemDo withVariants(LoyverseItemVariantDo... variants) {
    variants().updateAll(variants);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<LoyverseItemVariantDo> getVariants() {
    return variants().get();
  }
}
