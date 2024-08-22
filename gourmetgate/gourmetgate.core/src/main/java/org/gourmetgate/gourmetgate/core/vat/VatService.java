package org.gourmetgate.gourmetgate.core.vat;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupResultDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupRowDo;
import org.gourmetgate.gourmetgate.data.vat.IVatRepository;
import org.gourmetgate.gourmetgate.data.vat.VatDo;

import java.util.List;

public class VatService implements IService {

  public LookupResultDo lookupVat(LookupRestrictionDo restriction) {
    LookupResultDo result = BEANS.get(LookupResultDo.class);
    List<LookupRowDo> lookupRows = BEANS.get(IVatRepository.class).search(restriction)
      .map(this::fromDoToLookupRow)
      .toList();
    result.withRows(lookupRows);
    return result;
  }

  protected LookupRowDo fromDoToLookupRow(VatDo vat) {
    return BEANS.get(LookupRowDo.class)
      .withId(vat.getVatId())
      .withText(String.format("%s %%", vat.getPercent()));
  }
}
