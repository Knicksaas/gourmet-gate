package org.gourmetgate.gourmetgate.persistence.vat;

import org.gourmetgate.gourmetgate.data.vat.IVatRepository;
import org.gourmetgate.gourmetgate.data.vat.VatDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Vat;
import org.gourmetgate.gourmetgate.persistence.tables.records.VatRecord;
import org.jooq.Field;

public class VatRepository extends AbstractRepository<Vat, VatRecord, VatDo> implements IVatRepository {

  @Override
  public Vat getTable() {
    return Vat.VAT;
  }

  @Override
  public Field<String> getIdColumn() {
    return Vat.VAT.VAT_ID;
  }

  @Override
  protected DoEntityBeanMappings<VatDo, VatRecord> mappings() {
    return new DoEntityBeanMappings<VatDo, VatRecord>()
      .with(VatDo::vatId, VatRecord::getVatId, VatRecord::setVatId)
      .with(VatDo::percent, VatRecord::getPercent, VatRecord::setPercent);
  }
}
