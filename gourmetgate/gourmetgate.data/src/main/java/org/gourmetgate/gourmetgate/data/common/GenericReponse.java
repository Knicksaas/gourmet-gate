package org.gourmetgate.gourmetgate.data.common;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.GenericResponse")
public class GenericReponse<E extends DoEntity> extends DoEntity {

  public DoList<E> items() {
    return doList("items");
  }

  public GenericReponse<E> withItem(E cartCountDos) {
    items().get().add(cartCountDos);
    return this;
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public GenericReponse<E> withItems(Collection<? extends E> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public GenericReponse<E> withItems(E... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<E> getItems() {
    return items().get();
  }
}
