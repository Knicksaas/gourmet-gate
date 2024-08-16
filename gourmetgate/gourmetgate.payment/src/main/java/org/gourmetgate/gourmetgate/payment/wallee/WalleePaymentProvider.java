package org.gourmetgate.gourmetgate.payment.wallee;

import com.wallee.sdk.ApiClient;
import com.wallee.sdk.model.*;
import com.wallee.sdk.service.TransactionPaymentPageService;
import com.wallee.sdk.service.TransactionService;
import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.gourmetgate.gourmetgate.data.cart.CartItemDo;
import org.gourmetgate.gourmetgate.data.payment.IPaymenetRepository;
import org.gourmetgate.gourmetgate.data.payment.PaymentDataDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentStatus;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

import java.math.BigDecimal;

public class WalleePaymentProvider implements IPaymentProvider {

  private Long spaceId;
  private TransactionPaymentPageService transactionPaymentPageService;
  private TransactionService transactionService;

  @PostConstruct
  public void init() {
    Long applicationUserId = CONFIG.getPropertyValue(WalleePaymentProperties.WalleeUserIdProperty.class);
    String authenticationKey = CONFIG.getPropertyValue(WalleePaymentProperties.WalleeAuthKeyProperty.class);
    spaceId = CONFIG.getPropertyValue(WalleePaymentProperties.WalleeSpaceIdProperty.class);

    // Services
    ApiClient apiClient = new ApiClient(applicationUserId, authenticationKey);
    transactionPaymentPageService = new TransactionPaymentPageService(apiClient);
    transactionService = new TransactionService(apiClient);
  }


  /**
   * Create Payment Page URL
   * <p>
   * This operation creates the URL to which the user should be redirected to when the payment page should be used.
   */
  @Override
  public String createPaymentLink(PaymentDataDo payment) {
    try {
      Transaction transaction = this.transactionService.create(this.spaceId, createTransactionPayload(payment));
      createPaymentInDatabase(transaction, payment);
      return this.transactionPaymentPageService.paymentPageUrl(spaceId, transaction.getId());
    } catch (Exception e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  protected TransactionCreate createTransactionPayload(PaymentDataDo paymentDo) {
    TransactionCreate transactionPayload = new TransactionCreate();
    transactionPayload.autoConfirmationEnabled(true)
      .currency("CHF")
      .language("de-CH")
      .successUrl("http://localhost:8084/success.html")
      .failedUrl("http://localhost:8084/failed.html");

    paymentDo.getCartItems().stream()
      .map(this::createLineItem)
      .forEach(transactionPayload::addLineItemsItem);

    return transactionPayload;
  }

  protected LineItemCreate createLineItem(CartItemDo cartItem) {
    LineItemCreate lineItem = new LineItemCreate();
    lineItem
      .uniqueId(cartItem.getOrderPositionId())
      .name(getLineItemName(cartItem))
      .type(LineItemType.PRODUCT)
      .quantity(BigDecimal.ONE)
      .amountIncludingTax(cartItem.getPrice())
      .shippingRequired(false);
    return lineItem;
  }

  protected String getLineItemName(CartItemDo cartItem) {
    String name = cartItem.getArticleName();
    if (cartItem.getHasOptions()) {
      name += String.format(" (%s)", cartItem.getOptions());
    }
    return name;
  }

  protected void createPaymentInDatabase(Transaction transaction, PaymentDataDo paymentData) {
    PaymentDo paymentDo = BEANS.get(PaymentDo.class);
    paymentDo.withPaymentExtId(String.valueOf(transaction.getId()));
    paymentDo.withOrderId(paymentData.getOrderId());
    paymentDo.withStatus(PaymentStatus.CREATED);
    BEANS.get(IPaymenetRepository.class).create(paymentDo);
  }

  @Override
  public PaymentStatus fetchTransactionStatus(String extTransactionId) {
    try {
      Transaction transaction = transactionService.read(this.spaceId, Long.valueOf(extTransactionId));
      return parseStatus(transaction.getState());
    } catch (Exception e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  protected PaymentStatus parseStatus(TransactionState transactionState) {
    switch (transactionState) {
      case FULFILL -> {
        return PaymentStatus.PAID;
      }
      case FAILED, VOIDED, DECLINE -> {
        return PaymentStatus.FAILED;
      }
      default -> {
        return PaymentStatus.CREATED;
      }
    }
  }
}
