package org.gourmetgate.gourmetgate.data.payment;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;
import org.gourmetgate.gourmetgate.data.common.EnumUtility;

@TypeName("gourmetgate.Payment")
public class PaymentDo extends DoEntity {

  public DoValue<String> paymentId() {
    return doValue("paymentId");
  }

  public DoValue<String> paymentExtId() {
    return doValue("paymentExtId");
  }

  public DoValue<String> orderId() {
    return doValue("orderId");
  }

  public DoValue<String> status() {
    return doValue("status");
  }

  public PaymentDo withStatus(PaymentStatus status) {
    return withStatus(status.toString());
  }

  public PaymentStatus getPaymentStatus() {
    return EnumUtility.getEnumFromString(PaymentStatus.class, getStatus());
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withPaymentId(String paymentId) {
    paymentId().set(paymentId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPaymentId() {
    return paymentId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withPaymentExtId(String paymentExtId) {
    paymentExtId().set(paymentExtId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPaymentExtId() {
    return paymentExtId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withOrderId(String orderId) {
    orderId().set(orderId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderId() {
    return orderId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PaymentDo withStatus(String status) {
    status().set(status);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getStatus() {
    return status().get();
  }
}
