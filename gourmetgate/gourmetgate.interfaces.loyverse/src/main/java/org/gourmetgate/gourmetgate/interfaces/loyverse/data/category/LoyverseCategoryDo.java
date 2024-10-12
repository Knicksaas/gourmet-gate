package org.gourmetgate.gourmetgate.interfaces.loyverse.data.category;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.ValueFormat;
import org.gourmetgate.gourmetgate.interfaces.loyverse.rest.LoyverseRestClientHelper;

import java.util.Date;

public class LoyverseCategoryDo extends DoEntity {

  public DoValue<String> id() {
    return doValue("id");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> color() {
    return doValue("color");
  }

  @ValueFormat(pattern = LoyverseRestClientHelper.DATE_PATTERN)
  public DoValue<Date> createdAt() {
    return doValue("created_at");
  }

  @ValueFormat(pattern = LoyverseRestClientHelper.DATE_PATTERN)
  public DoValue<Date> deletedAt() {
    return doValue("deleted_at");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryDo withId(String id) {
    id().set(id);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getId() {
    return id().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryDo withColor(String color) {
    color().set(color);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getColor() {
    return color().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryDo withCreatedAt(Date createdAt) {
    createdAt().set(createdAt);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Date getCreatedAt() {
    return createdAt().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LoyverseCategoryDo withDeletedAt(Date deletedAt) {
    deletedAt().set(deletedAt);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Date getDeletedAt() {
    return deletedAt().get();
  }
}
