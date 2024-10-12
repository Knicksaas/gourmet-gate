package org.gourmetgate.gourmetgate.interfaces.loyverse.data.item;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.math.BigDecimal;

public class LoyverseItemVariantDo extends DoEntity {

  public DoValue<String> variantId() {
    return doValue("variant_id");
  }

  public DoValue<String> option1Value() {
    return doValue("option1_value");
  }

  public DoValue<BigDecimal> defaultPrice() {
    return doValue("default_price");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemVariantDo withVariantId(String variantId) {
    variantId().set(variantId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getVariantId() {
    return variantId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemVariantDo withOption1Value(String option1Value) {
    option1Value().set(option1Value);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOption1Value() {
    return option1Value().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseItemVariantDo withDefaultPrice(BigDecimal defaultPrice) {
    defaultPrice().set(defaultPrice);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getDefaultPrice() {
    return defaultPrice().get();
  }
}
