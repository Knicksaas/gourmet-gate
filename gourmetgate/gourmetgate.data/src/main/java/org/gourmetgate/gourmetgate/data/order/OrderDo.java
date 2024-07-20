package org.gourmetgate.gourmetgate.data.order;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDo extends DoEntity {

  public DoValue<String> orderId() {
    return doValue("orderId");
  }

  public DoValue<String> tableId() {
    return doValue("tableId");
  }

  public DoValue<String> status() {
    return doValue("status");
  }

  public DoValue<BigDecimal> tip() {
    return doValue("tip");
  }

  public DoValue<LocalDate> evtCreate() {
    return doValue("evtCreate");
  }

  public DoValue<LocalDate> evtPay() {
    return doValue("evtPay");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withOrderId(String orderId) {
    orderId().set(orderId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderId() {
    return orderId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withTableId(String tableId) {
    tableId().set(tableId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getTableId() {
    return tableId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withStatus(String status) {
    status().set(status);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getStatus() {
    return status().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withTip(BigDecimal tip) {
    tip().set(tip);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getTip() {
    return tip().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withEvtCreate(LocalDate evtCreate) {
    evtCreate().set(evtCreate);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LocalDate getEvtCreate() {
    return evtCreate().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderDo withEvtPay(LocalDate evtPay) {
    evtPay().set(evtPay);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LocalDate getEvtPay() {
    return evtPay().get();
  }
}
