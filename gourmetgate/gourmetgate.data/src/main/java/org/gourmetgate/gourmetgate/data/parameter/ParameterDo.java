package org.gourmetgate.gourmetgate.data.parameter;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.Parameter")
public class ParameterDo extends DoEntity {

  public DoValue<String> parameterId() {
    return doValue("parameterId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> value() {
    return doValue("value");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ParameterDo withParameterId(String parameterId) {
    parameterId().set(parameterId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getParameterId() {
    return parameterId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ParameterDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ParameterDo withValue(String value) {
    value().set(value);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getValue() {
    return value().get();
  }
}
