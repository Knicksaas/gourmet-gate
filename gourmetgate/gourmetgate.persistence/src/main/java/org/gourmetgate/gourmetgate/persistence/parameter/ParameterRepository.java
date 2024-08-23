package org.gourmetgate.gourmetgate.persistence.parameter;

import org.gourmetgate.gourmetgate.data.parameter.IParameterRepository;
import org.gourmetgate.gourmetgate.data.parameter.ParameterDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Parameter;
import org.gourmetgate.gourmetgate.persistence.tables.records.ParameterRecord;
import org.jooq.Field;

public class ParameterRepository extends AbstractRepository<Parameter, ParameterRecord, ParameterDo> implements IParameterRepository {

  @Override
  public Parameter getTable() {
    return Parameter.PARAMETER;
  }

  @Override
  public Field<String> getIdColumn() {
    return Parameter.PARAMETER.NAME;
  }

  @Override
  protected void setPrimaryKey(ParameterRecord record, String key) {
    record.set(getTable().PARAMETER_ID, key);
  }

  @Override
  protected DoEntityBeanMappings<ParameterDo, ParameterRecord> mappings() {
    return new DoEntityBeanMappings<ParameterDo, ParameterRecord>()
      .with(ParameterDo::parameterId, ParameterRecord::getParameterId, ParameterRecord::setParameterId)
      .with(ParameterDo::name, ParameterRecord::getName, ParameterRecord::setName)
      .with(ParameterDo::value, ParameterRecord::getValue, ParameterRecord::setValue);
  }
}
