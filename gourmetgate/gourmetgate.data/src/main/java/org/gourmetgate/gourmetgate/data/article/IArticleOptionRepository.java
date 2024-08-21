package org.gourmetgate.gourmetgate.data.article;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.stream.Stream;

public interface IArticleOptionRepository extends ICrudRepository<ArticleOptionDo> {

  Stream<ArticleOptionDo> getArticleOptionsForArticle(String articleId);

  int deleteArticleOptionsForArticle(String articleId);

  int deleteArticleOptionsForArticleGroup(String articleGroupId);
}
