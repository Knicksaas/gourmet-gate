package org.gourmetgate.gourmetgate.data.lookup;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;

import java.util.Collection;
import java.util.List;

public class LookupResultDo extends DoEntity {

  public DoList<LookupRowDo> rows() {
    return doList("rows");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public LookupResultDo withRows(Collection<? extends LookupRowDo> rows) {
    rows().updateAll(rows);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public LookupResultDo withRows(LookupRowDo... rows) {
    rows().updateAll(rows);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<LookupRowDo> getRows() {
    return rows().get();
  }
}
