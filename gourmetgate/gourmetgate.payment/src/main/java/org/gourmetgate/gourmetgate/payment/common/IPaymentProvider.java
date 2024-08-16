package org.gourmetgate.gourmetgate.payment.common;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.payment.PaymentDataDo;

@ApplicationScoped
public interface IPaymentProvider {

  String createPaymentLink(PaymentDataDo payment);

  void registerTransactionChange(String extTransactionId);
}
