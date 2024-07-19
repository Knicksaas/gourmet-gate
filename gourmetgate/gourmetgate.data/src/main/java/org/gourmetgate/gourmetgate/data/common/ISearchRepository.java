package org.gourmetgate.gourmetgate.data.common;

import org.eclipse.scout.rt.dataobject.DoEntity;

import java.util.stream.Stream;

public interface ISearchRepository<ENTITY extends DoEntity, RESTRICTION extends DoEntity> {

  Stream<ENTITY> search(RESTRICTION restriction);
}
