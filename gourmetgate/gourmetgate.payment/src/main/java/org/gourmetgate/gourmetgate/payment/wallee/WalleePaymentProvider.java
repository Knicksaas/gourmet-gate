package org.gourmetgate.gourmetgate.payment.wallee;

import com.wallee.sdk.ApiClient;
import com.wallee.sdk.model.LineItemCreate;
import com.wallee.sdk.model.LineItemType;
import com.wallee.sdk.model.Transaction;
import com.wallee.sdk.model.TransactionCreate;
import com.wallee.sdk.service.TransactionPaymentPageService;
import com.wallee.sdk.service.TransactionService;
import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.gourmetgate.gourmetgate.data.cart.CartItemDo;
import org.gourmetgate.gourmetgate.data.payment.PaymentDataDo;
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

  @Override
  public void registerTransactionChange(String extTransactionId) {
    try {
      Transaction transaction = transactionService.read(this.spaceId, Long.valueOf(extTransactionId));
      // save state to database
    } catch (Exception e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }
}
