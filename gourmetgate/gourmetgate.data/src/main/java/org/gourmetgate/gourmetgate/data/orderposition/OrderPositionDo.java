package org.gourmetgate.gourmetgate.data.orderposition;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;

@TypeName("gourmetgate.OrderPosition")
public class OrderPositionDo extends DoEntity {

  public DoValue<String> orderPositionId() {
    return doValue("orderPositionId");
  }

  public DoValue<String> orderId() {
    return doValue("orderId");
  }

  public DoValue<String> articleId() {
    return doValue("articleId");
  }

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  public DoValue<Double> vat() {
    return doValue("vat");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionDo withOrderPositionId(String orderPositionId) {
    orderPositionId().set(orderPositionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderPositionId() {
    return orderPositionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionDo withOrderId(String orderId) {
    orderId().set(orderId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderId() {
    return orderId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionDo withArticleId(String articleId) {
    articleId().set(articleId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleId() {
    return articleId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionDo withVat(Double vat) {
    vat().set(vat);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Double getVat() {
    return vat().get();
  }
}
