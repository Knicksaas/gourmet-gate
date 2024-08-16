package org.gourmetgate.gourmetgate.data.payment;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;
import org.gourmetgate.gourmetgate.data.cart.CartItemDo;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.Payment")
public class PaymentDo extends DoEntity {

  public DoList<CartItemDo> cartItems() {
    return doList("cartItems");
  }


  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withCartItems(Collection<? extends CartItemDo> cartItems) {
    cartItems().updateAll(cartItems);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withCartItems(CartItemDo... cartItems) {
    cartItems().updateAll(cartItems);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<CartItemDo> getCartItems() {
    return cartItems().get();
  }
}
