package org.gourmetgate.gourmetgate.payment.common;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;

@ApplicationScoped
public interface IPaymentProvider {

  String createPaymentLink(PaymentDo payment);
}
