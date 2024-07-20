package org.gourmetgate.gourmetgate.data.article;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.math.BigDecimal;

public class ArticleDo extends DoEntity {

  public DoValue<String> articleId() {
    return doValue("articleId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> description() {
    return doValue("description");
  }

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  public DoValue<Boolean> options() {
    return doValue("options");
  }

  public DoValue<String> vatId() {
    return doValue("vatId");
  }

  public DoValue<String> status() {
    return doValue("status");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withArticleId(String articleId) {
    articleId().set(articleId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleId() {
    return articleId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withDescription(String description) {
    description().set(description);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withOptions(Boolean options) {
    options().set(options);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getOptions() {
    return options().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isOptions() {
    return nvl(getOptions());
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withVatId(String vatId) {
    vatId().set(vatId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getVatId() {
    return vatId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleDo withStatus(String status) {
    status().set(status);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getStatus() {
    return status().get();
  }
}
