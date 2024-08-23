package org.gourmetgate.gourmetgate.core.parameter;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;

@ApplicationScoped
public abstract class AbstractParameter<T> {

  private final String m_name;

  public AbstractParameter(String name) {
    if (!name.toLowerCase().endsWith("parameter")) {
      name += "Parameter";
    }
    m_name = name;
  }

  public String getName() {
    return m_name;
  }

  public T getValue() {
    return parseValue(getRawValue());
  }

  public String getRawValue() {
    return BEANS.get(ParameterSerivce.class).getParameterValue(getName())
      .orElseGet(() -> BEANS.get(ParameterSerivce.class).createParameter(getName(), prepareValue(getDefaultValue())));
  }

  public void setValue(T value) {
    setRawValue(prepareValue(value));
  }

  public void setRawValue(String value) {
    BEANS.get(ParameterSerivce.class).updateParameterValue(getName(), value);
  }

  /**
   * Override this method to provide a default value
   *
   * @return default value of the parameter
   */
  protected T getDefaultValue() {
    return null;
  }

  /**
   * Parse the string value from the database to the wished value
   *
   * @param value string value to parse
   * @return the parsed value
   */
  protected abstract T parseValue(String value);

  /**
   * Prepare the value to be stored in the database. This requires converting it into string format
   *
   * @param value value to be stored
   * @return string representation of the value
   */
  public abstract String prepareValue(T value);
}
