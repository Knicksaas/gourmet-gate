package org.gourmetgate.gourmetgate.data.article;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;

@TypeName("gourmetgate.ArticleTablePageEntry")
public class ArticleTablePageEntryDo extends DoEntity {

  public DoValue<String> id() {
    return doValue("id");
  }

  public DoValue<String> parentId() {
    return doValue("parentId");
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


  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withId(String id) {
    id().set(id);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getId() {
    return id().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withParentId(String parentId) {
    parentId().set(parentId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getParentId() {
    return parentId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withUnit(String unit) {
    unit().set(unit);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getUnit() {
    return unit().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ArticleTablePageEntryDo withOptions(Boolean options) {
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
}
