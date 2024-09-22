package org.gourmetgate.gourmetgate.core.application;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.application.ApplicationStatus;

public class ApplicationService implements IService {

  public ApplicationStatus getApplicationStatus() {
    boolean paused = BEANS.get(ApplicationPausedParameter.class).getValue();
    return paused ? ApplicationStatus.PAUSED : ApplicationStatus.OPEN;
  }
}
