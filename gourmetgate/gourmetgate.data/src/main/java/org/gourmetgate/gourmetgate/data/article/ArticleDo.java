package org.gourmetgate.gourmetgate.data.article;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;

@TypeName("gourmetgate.Article")
public class ArticleDo extends DoEntity {

  public DoValue<String> articleId() {
    return doValue("articleId");
  }

  public DoValue<String> articleGroupId() {
    return doValue("articleGroupId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> unit() {
    return doValue("unit");
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

  public DoValue<Boolean> enabled() {
    return doValue("enabled");
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
  public ArticleDo withArticleGroupId(String articleGroupId) {
    articleGroupId().set(articleGroupId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleGroupId() {
    return articleGroupId().get();
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
  public ArticleDo withUnit(String unit) {
    unit().set(unit);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getUnit() {
    return unit().get();
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
  public ArticleDo withEnabled(Boolean enabled) {
    enabled().set(enabled);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getEnabled() {
    return enabled().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isEnabled() {
    return nvl(getEnabled());
  }
}
