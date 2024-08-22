package org.gourmetgate.gourmetgate.data.lookup;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

public class LookupRowDo extends DoEntity {

  public DoValue<String> id() {
    return doValue("id");
  }

  public DoValue<String> parentId() {
    return doValue("parentId");
  }

  public DoValue<String> text() {
    return doValue("text");
  }

  public DoValue<Boolean> enabled() {
    return doValue("enabled");
  }

  public DoValue<Boolean> active() {
    return doValue("active");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRowDo withId(String id) {
    id().set(id);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getId() {
    return id().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRowDo withParentId(String parentId) {
    parentId().set(parentId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getParentId() {
    return parentId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRowDo withText(String text) {
    text().set(text);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getText() {
    return text().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRowDo withEnabled(Boolean enabled) {
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

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRowDo withActive(Boolean active) {
    active().set(active);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getActive() {
    return active().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isActive() {
    return nvl(getActive());
  }
}
