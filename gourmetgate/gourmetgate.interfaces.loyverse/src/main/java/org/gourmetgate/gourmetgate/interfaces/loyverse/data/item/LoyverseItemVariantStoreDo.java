package org.gourmetgate.gourmetgate.interfaces.loyverse.data.item;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.math.BigDecimal;

public class LoyverseItemVariantStoreDo extends DoEntity {

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  public DoValue<Boolean> availableForSale() {
    return doValue("available_for_sale");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemVariantStoreDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemVariantStoreDo withAvailableForSale(Boolean availableForSale) {
    availableForSale().set(availableForSale);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getAvailableForSale() {
    return availableForSale().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isAvailableForSale() {
    return nvl(getAvailableForSale());
  }
}
