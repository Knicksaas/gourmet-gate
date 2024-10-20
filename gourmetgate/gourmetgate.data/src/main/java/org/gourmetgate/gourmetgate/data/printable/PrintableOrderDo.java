package org.gourmetgate.gourmetgate.data.printable;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PrintableOrderDo extends DoEntity {

  public DoValue<String> printableOrderId() {
    return doValue("printableOrderId");
  }

  public DoValue<String> tableNr() {
    return doValue("tableNr");
  }

  public DoValue<Date> evtCreated() {
    return doValue("evtCreated");
  }

  public DoList<PrintableOrderPositionDo> orderPositions() {
    return doList("orderPositions");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderDo withPrintableOrderId(String printableOrderId) {
    printableOrderId().set(printableOrderId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPrintableOrderId() {
    return printableOrderId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderDo withTableNr(String tableNr) {
    tableNr().set(tableNr);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getTableNr() {
    return tableNr().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderDo withEvtCreated(Date evtCreated) {
    evtCreated().set(evtCreated);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Date getEvtCreated() {
    return evtCreated().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderDo withOrderPositions(Collection<? extends PrintableOrderPositionDo> orderPositions) {
    orderPositions().updateAll(orderPositions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderDo withOrderPositions(PrintableOrderPositionDo... orderPositions) {
    orderPositions().updateAll(orderPositions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<PrintableOrderPositionDo> getOrderPositions() {
    return orderPositions().get();
  }
}
