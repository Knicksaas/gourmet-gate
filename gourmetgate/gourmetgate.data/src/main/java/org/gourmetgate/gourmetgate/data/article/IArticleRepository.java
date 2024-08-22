package org.gourmetgate.gourmetgate.data.article;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.stream.Stream;

public interface IArticleRepository extends ICrudRepository<ArticleDo> {

  int deleteByGroupId(String articleGroupId);

  Stream<ArticleDo> allEnabled();
}
