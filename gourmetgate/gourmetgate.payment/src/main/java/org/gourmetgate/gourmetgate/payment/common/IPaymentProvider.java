package org.gourmetgate.gourmetgate.payment.common;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.payment.PaymentDataDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentStatus;

@ApplicationScoped
public interface IPaymentProvider {

  String createPaymentLink(PaymentDataDo payment);

  PaymentStatus fetchTransactionStatus(String extTransactionId);
}
