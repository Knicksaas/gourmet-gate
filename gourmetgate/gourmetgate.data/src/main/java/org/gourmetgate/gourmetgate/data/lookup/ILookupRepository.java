package org.gourmetgate.gourmetgate.data.lookup;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.gourmetgate.gourmetgate.data.common.ISearchRepository;

public interface ILookupRepository<ENTITY extends DoEntity> extends ISearchRepository<ENTITY, LookupRestrictionDo> {

}
