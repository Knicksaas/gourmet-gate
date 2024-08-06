package org.gourmetgate.gourmetgate.core.cart;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.cart.CartFormDataDo;
import org.gourmetgate.gourmetgate.data.cart.CartItemDo;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.OrderPositionOptionDo;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class CartFormService implements IService {

  public CartFormDataDo getCartFormData(String orderId) {
    CartFormDataDo formData = BEANS.get(CartFormDataDo.class);
    List<CartItemDo> cartItems = BEANS.get(IOrderPositionRepository.class).getCartItemsByOrderId(orderId)
      .map(item -> item.getHasOptions()
        ? item.withOptions(getOrderTextForOrderPositionId(item.getOrderPositionId()))
        : item)
      .toList();
    formData.withCartItems(cartItems);
    formData.withPrice(getPrice(cartItems.stream()));
    return formData;
  }

  private String getOrderTextForOrderPositionId(String orderPositionId) {
    List<String> selectedOptions = BEANS.get(IOrderPositionOptionRepository.class).getOrderPositionsOptions(orderPositionId)
      .filter(OrderPositionOptionDo::isSelected)
      .map(OrderPositionOptionDo::getDescription)
      .toList();
    return String.join(", ", selectedOptions);
  }

  private BigDecimal getPrice(Stream<CartItemDo> cartItems) {
    return cartItems
      .map(CartItemDo::getPrice).
      reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
