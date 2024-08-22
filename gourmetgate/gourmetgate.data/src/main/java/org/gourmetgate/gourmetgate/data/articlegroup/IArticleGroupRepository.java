package org.gourmetgate.gourmetgate.data.articlegroup;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.lookup.ILookupRepository;

public interface IArticleGroupRepository extends ICrudRepository<ArticleGroupDo>, ILookupRepository<ArticleGroupDo> {
}
