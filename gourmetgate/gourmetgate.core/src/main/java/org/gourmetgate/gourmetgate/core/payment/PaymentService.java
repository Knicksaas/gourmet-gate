package org.gourmetgate.gourmetgate.core.payment;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.gourmetgate.gourmetgate.core.cart.CartFormService;
import org.gourmetgate.gourmetgate.data.cart.CartFormDataDo;
import org.gourmetgate.gourmetgate.data.infopage.InfoTileBeanDo;
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

  public InfoTileBeanDo getPaymentStatusDo(String orderId) {
    PaymentStatus status = BEANS.get(IPaymenetRepository.class).getByOrderId(orderId)
      .map(PaymentDo::getPaymentStatus)
      .orElse(PaymentStatus.CREATED);

    return buildPaymentStatusDo(status);
  }

  protected InfoTileBeanDo buildPaymentStatusDo(PaymentStatus status) {
    InfoTileBeanDo paymentStatusDo = BEANS.get(InfoTileBeanDo.class)
      .withPaymentStatus(status.toString());

    switch (status) {
      case PAID -> paymentStatusDo
        .withTitle(TEXTS.get("OrderSuccessfull"))
        .withButtonLabel(TEXTS.get("CreateNewOrder"))
        .withIconClass("gg-icon-check")
        .withInfoColorClass("info-color-green");
      case FAILED -> paymentStatusDo
        .withTitle(TEXTS.get("PaymentFailed"))
        .withButtonLabel(TEXTS.get("TryAgain"))
        .withIconClass("gg-icon-cross")
        .withInfoColorClass("info-color-red");
      default -> paymentStatusDo
        .withTitle(TEXTS.get("PaymentPending"))
        .withDescription(TEXTS.get("PaymentNotCompleted"))
        .withButtonLabel(TEXTS.get("NavigationBackward"))
        .withIconClass("gg-icon-help")
        .withInfoColorClass("info-color-light-blue");
    }
    return paymentStatusDo;
  }
}
