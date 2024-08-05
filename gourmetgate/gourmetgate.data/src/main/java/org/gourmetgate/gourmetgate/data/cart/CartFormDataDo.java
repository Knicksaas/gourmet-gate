package org.gourmetgate.gourmetgate.data.cart;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class CartFormDataDo extends DoEntity {

  public DoList<CartItemDo> cartItems() {
    return doList("cartItems");
  }

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public CartFormDataDo withCartItems(Collection<? extends CartItemDo> cartItems) {
    cartItems().updateAll(cartItems);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartFormDataDo withCartItems(CartItemDo... cartItems) {
    cartItems().updateAll(cartItems);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<CartItemDo> getCartItems() {
    return cartItems().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CartFormDataDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }
}
