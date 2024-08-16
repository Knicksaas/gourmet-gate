package org.gourmetgate.gourmetgate.payment.wallee;

import com.wallee.sdk.ApiClient;
import com.wallee.sdk.model.*;
import com.wallee.sdk.service.TransactionPaymentPageService;
import com.wallee.sdk.service.TransactionService;
import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.gourmetgate.gourmetgate.data.payment.PaymentDo;
import org.gourmetgate.gourmetgate.payment.common.IPaymentProvider;

import java.math.BigDecimal;

public class WalleePaymentProvider implements IPaymentProvider {

  @PostConstruct
  public void init() {
    this.apiClient = new ApiClient(applicationUserId, authenticationKey);
    this.transactionPaymentPageService = new TransactionPaymentPageService(this.apiClient);
    this.transactionService = new TransactionService(this.apiClient);
  }

  // Credentials
  private Long spaceId = Long.valueOf(CONFIG.getPropertyValue(WalleePaymentProperties.WalleeSpaceIdProperty.class));
  private Long applicationUserId = Long.valueOf(CONFIG.getPropertyValue(WalleePaymentProperties.WalleeUserIdProperty.class));

  private String authenticationKey = CONFIG.getPropertyValue(WalleePaymentProperties.WalleeAuthKeyProperty.class);
  // Services
  private ApiClient apiClient;
  private TransactionPaymentPageService transactionPaymentPageService;

  private TransactionService transactionService;
  // Models

  private TransactionCreate transactionPayload;

  /**
   * Get transaction payload
   *
   * @return TransactionCreate
   */
  private TransactionCreate getTransactionPayload() {
    if (this.transactionPayload == null) {
      // Line item
      LineItemCreate lineItem = new LineItemCreate();
      lineItem.name("Red T-Shirt")
        .uniqueId("5412")
        .type(LineItemType.PRODUCT)
        .quantity(BigDecimal.valueOf(1))
        .amountIncludingTax(BigDecimal.valueOf(29.95))
        .sku("red-t-shirt-123");

      // Customer Billind Address
      AddressCreate billingAddress = new AddressCreate();
      billingAddress.city("Winterthur")
        .country("CH")
        .emailAddress("test@example.com")
        .familyName("Customer")
        .givenName("Good")
        .postcode("8400")
        .postalState("ZH")
        .organizationName("Test GmbH")
        .mobilePhoneNumber("+41791234567")
        .salutation("Ms");

      this.transactionPayload = new TransactionCreate();
      this.transactionPayload.autoConfirmationEnabled(true).currency("CHF").language("de-CH");
      this.transactionPayload.setBillingAddress(billingAddress);
      this.transactionPayload.setShippingAddress(billingAddress);
      this.transactionPayload.addLineItemsItem(lineItem);
    }
    return this.transactionPayload;
  }

  /**
   * Build Payment Page URL
   * <p>
   * This operation creates the URL to which the user should be redirected to when the payment page should be used.
   */
  @Override
  public String createPaymentLink(PaymentDo payment) {
    try {
      Transaction transaction = this.transactionService.create(this.spaceId, this.getTransactionPayload());
      return this.transactionPaymentPageService.paymentPageUrl(spaceId, transaction.getId());
    } catch (Exception e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }
}
