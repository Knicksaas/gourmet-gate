package org.gourmetgate.gourmetgate.core.payment;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.core.cart.CartFormService;
import org.gourmetgate.gourmetgate.data.cart.CartFormDataDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

public class PaymentService implements IService {

  public String createPayment(String orderId) {
    PaymentDo paymentDo = BEANS.get(PaymentDo.class);
    CartFormDataDo orderData = BEANS.get(CartFormService.class).getCartFormData(orderId);
    paymentDo.withCartItems(orderData.getCartItems());
    return BEANS.get(IPaymentProvider.class).createPaymentLink(paymentDo);
  }

  public void registerTransactionChange(String extTransactionId) {
    BEANS.get(IPaymentProvider.class).registerTransactionChange(extTransactionId);
  }
}
