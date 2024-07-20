package org.gourmetgate.gourmetgate.data.vat;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

public class VatDo extends DoEntity {

  public DoValue<String> vatId() {
    return doValue("vatId");
  }

  public DoValue<Double> percent() {
    return doValue("percent");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VatDo withVatId(String vatId) {
    vatId().set(vatId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getVatId() {
    return vatId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VatDo withPercent(Double percent) {
    percent().set(percent);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Double getPercent() {
    return percent().get();
  }
}
