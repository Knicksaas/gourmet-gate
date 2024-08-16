package org.gourmetgate.gourmetgate.core.payment;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.gourmetgate.gourmetgate.core.cart.CartFormService;
import org.gourmetgate.gourmetgate.data.cart.CartFormDataDo;
import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.order.OrderDo;
import org.gourmetgate.gourmetgate.data.payment.IPaymenetRepository;
import org.gourmetgate.gourmetgate.data.payment.PaymentDataDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentStatus;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

import java.util.Date;

public class PaymentService implements IService {

  public String createPayment(String orderId) {
    CartFormDataDo orderData = BEANS.get(CartFormService.class).getCartFormData(orderId);
    PaymentDataDo paymentDo = BEANS.get(PaymentDataDo.class)
      .withCartItems(orderData.getCartItems())
      .withOrderId(orderId);
    return BEANS.get(IPaymentProvider.class).createPaymentLink(paymentDo);
  }

  public void handleTransactionStatusChange(String extTransactionId) {
    PaymentStatus newPaymentStatus = BEANS.get(IPaymentProvider.class).fetchTransactionStatus(extTransactionId);
    PaymentDo payment = BEANS.get(IPaymenetRepository.class).getByExtId(extTransactionId).orElseThrow();

    if (StringUtility.equalsIgnoreCase(payment.getStatus(), newPaymentStatus.toString())) {
      // status is equal, do noting
      return;
    }

    payment.withStatus(newPaymentStatus);
    BEANS.get(IPaymenetRepository.class).update(payment.getPaymentId(), payment);

    // Update evt_pay on order, when order is paid
    if (newPaymentStatus.equals(PaymentStatus.PAID)) {
      OrderDo order = BEANS.get(IOrderRepository.class).getById(payment.getOrderId()).orElseThrow();
      order.withEvtPay(new Date());
      BEANS.get(IOrderRepository.class).update(order.getOrderId(), order);
    }
  }
}
