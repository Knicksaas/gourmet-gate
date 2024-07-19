package org.gourmetgate.gourmetgate.data.person;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.common.ISearchRepository;

@ApplicationScoped
public interface IPersonRepository extends ICrudRepository<PersonDo>, ISearchRepository<PersonDo, PersonRestrictionDo> {

}
