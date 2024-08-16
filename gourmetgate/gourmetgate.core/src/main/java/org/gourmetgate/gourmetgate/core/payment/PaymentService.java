package org.gourmetgate.gourmetgate.core.payment;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

public class PaymentService implements IService {

  public String createPayment(String orderId) {
    PaymentDo paymentDo = BEANS.get(PaymentDo.class);
    return BEANS.get(IPaymentProvider.class).createPaymentLink(paymentDo);
  }
}
