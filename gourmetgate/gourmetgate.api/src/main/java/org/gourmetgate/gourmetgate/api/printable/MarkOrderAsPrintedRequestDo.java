package org.gourmetgate.gourmetgate.api.printable;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;

import java.util.Collection;
import java.util.List;

public class MarkOrderAsPrintedRequestDo extends DoEntity {

  public DoList<String> printedOrderIds() {
    return doList("printedOrderIds");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public MarkOrderAsPrintedRequestDo withPrintedOrderIds(Collection<? extends String> printedOrderIds) {
    printedOrderIds().updateAll(printedOrderIds);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public MarkOrderAsPrintedRequestDo withPrintedOrderIds(String... printedOrderIds) {
    printedOrderIds().updateAll(printedOrderIds);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<String> getPrintedOrderIds() {
    return printedOrderIds().get();
  }
}
