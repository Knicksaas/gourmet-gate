package org.gourmetgate.gourmetgate.data.lookup;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.Collection;
import java.util.List;

public class LookupRestrictionDo extends DoEntity {

  public DoList<String> ids() {
    return doList("ids");
  }

  public DoValue<String> text() {
    return doValue("text");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRestrictionDo withIds(Collection<? extends String> ids) {
    ids().updateAll(ids);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRestrictionDo withIds(String... ids) {
    ids().updateAll(ids);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<String> getIds() {
    return ids().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupRestrictionDo withText(String text) {
    text().set(text);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getText() {
    return text().get();
  }
}
