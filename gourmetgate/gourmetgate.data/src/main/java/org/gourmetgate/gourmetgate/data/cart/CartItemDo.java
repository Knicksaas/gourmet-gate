package org.gourmetgate.gourmetgate.data.cart;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;

@TypeName("CartItem")
public class CartItemDo extends DoEntity {

  public DoValue<String> orderPositionId() {
    return doValue("orderPositionId");
  }

  public DoValue<String> articleName() {
    return doValue("articleName");
  }

  public DoValue<String> unit() {
    return doValue("unit");
  }

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  public DoValue<Boolean> hasOptions() {
    return doValue("hasOptions");
  }

  public DoValue<String> options() {
    return doValue("options");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withOrderPositionId(String orderPositionId) {
    orderPositionId().set(orderPositionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderPositionId() {
    return orderPositionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withArticleName(String articleName) {
    articleName().set(articleName);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleName() {
    return articleName().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withUnit(String unit) {
    unit().set(unit);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getUnit() {
    return unit().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withHasOptions(Boolean hasOptions) {
    hasOptions().set(hasOptions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getHasOptions() {
    return hasOptions().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isHasOptions() {
    return nvl(getHasOptions());
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartItemDo withOptions(String options) {
    options().set(options);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOptions() {
    return options().get();
  }
}
