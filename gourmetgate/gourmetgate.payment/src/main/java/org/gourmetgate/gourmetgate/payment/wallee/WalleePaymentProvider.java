package org.gourmetgate.gourmetgate.payment.wallee;

import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

public class WalleePaymentProvider implements IPaymentProvider {

  @Override
  public String createPaymentLink(PaymentDo payment) {
    return null;
  }
}
