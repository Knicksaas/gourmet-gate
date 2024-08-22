package org.gourmetgate.gourmetgate.data.articlegroup;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;
import org.gourmetgate.gourmetgate.data.lookup.ILookupRepository;

import java.util.stream.Stream;

public interface IArticleGroupRepository extends ICrudRepository<ArticleGroupDo>, ILookupRepository<ArticleGroupDo> {

  Stream<ArticleGroupDo> getAllEnabled();
}
