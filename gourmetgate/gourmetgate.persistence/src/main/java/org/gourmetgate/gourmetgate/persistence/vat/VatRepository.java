package org.gourmetgate.gourmetgate.persistence.vat;

import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.gourmetgate.gourmetgate.data.vat.IVatRepository;
import org.gourmetgate.gourmetgate.data.vat.VatDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Vat;
import org.gourmetgate.gourmetgate.persistence.tables.records.VatRecord;
import org.jooq.Condition;
import org.jooq.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
  public Stream<VatDo> search(LookupRestrictionDo restriction) {
    Stream<VatDo> lookupById = super.search(restriction);
    if (restriction.text().exists()) {
      return lookupById.filter(vat -> String.valueOf(vat.getPercent()).equalsIgnoreCase(restriction.getText()));
    }
    return lookupById;
  }

  @Override
  protected List<Condition> buildSearchCondition(LookupRestrictionDo restriction) {
    List<Condition> conditions = new ArrayList<>();
    if (restriction.ids().exists()) {
      conditions.add(getIdColumn().in(restriction.getIds()));
    }
    return conditions;
  }

  @Override
  protected DoEntityBeanMappings<VatDo, VatRecord> mappings() {
    return new DoEntityBeanMappings<VatDo, VatRecord>()
      .with(VatDo::vatId, VatRecord::getVatId, VatRecord::setVatId)
      .with(VatDo::percent, VatRecord::getPercent, VatRecord::setPercent);
  }
}
