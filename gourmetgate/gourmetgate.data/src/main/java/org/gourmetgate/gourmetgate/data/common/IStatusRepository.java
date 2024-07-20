package org.gourmetgate.gourmetgate.data.common;

import org.eclipse.scout.rt.platform.ApplicationScoped;

@ApplicationScoped
public interface IStatusRepository<STATUS> {

  void updateStatus(String id, STATUS status);
}
