package org.gourmetgate.gourmetgate.data.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public interface ICrudRepository<ENTITY extends DoEntity> {

  ENTITY create(ENTITY entity);

  Optional<ENTITY> getById(String id);

  Stream<ENTITY> all();

  int update(String id, ENTITY entity);

  int delete(String id);
}
