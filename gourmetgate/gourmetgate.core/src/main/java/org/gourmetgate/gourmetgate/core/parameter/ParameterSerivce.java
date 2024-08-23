package org.gourmetgate.gourmetgate.core.parameter;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.parameter.IParameterRepository;
import org.gourmetgate.gourmetgate.data.parameter.ParameterDo;

import java.util.Optional;

public class ParameterSerivce implements IService {

  public AbstractParameter<?> getParameterClassByName(String name) {
    return BEANS.all(AbstractParameter.class).stream()
      .filter(param -> param.getName().equals(name))
      .findFirst()
      .orElse(null);
  }

  public Optional<String> getParameterValue(String name) {
    return BEANS.get(IParameterRepository.class).getById(name).map(ParameterDo::getValue);
  }

  public String createParameter(String name, String defaultValue) {
    ParameterDo newParameter = BEANS.get(ParameterDo.class)
      .withName(name)
      .withValue(defaultValue);
    return BEANS.get(IParameterRepository.class).create(newParameter).getValue();
  }

  public void updateParameterValue(String name, String newValue) {
    Optional<ParameterDo> parameter = BEANS.get(IParameterRepository.class).getById(name);
    if (parameter.isPresent()) {
      BEANS.get(IParameterRepository.class).update(name, parameter.get().withValue(newValue));
    } else {
      createParameter(name, newValue);
    }
  }
}
