package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.ArticleOptionDo;
import org.gourmetgate.gourmetgate.data.article.IArticleOptionRepository;

import java.util.List;
import java.util.stream.Stream;

public class ArticleOptionService implements IService {

  public Stream<ArticleOptionDo> createArticleOptions(List<ArticleOptionDo> articleOptions) {
    return articleOptions.stream()
      .map(option -> BEANS.get(IArticleOptionRepository.class).create(option));
  }

  public Stream<ArticleOptionDo> getArticleOptionForArticle(String articleId) {
    return BEANS.get(IArticleOptionRepository.class).getArticleOptionsForArticle(articleId);
  }

  public void updateArticleOptions(String articleId, List<ArticleOptionDo> articleOptions) {
    deleteArticleOptionsForArticle(articleId);
    createArticleOptions(articleOptions).toList();
  }

  public int deleteArticleOptionsForArticle(String articleId) {
    return BEANS.get(IArticleOptionRepository.class).deleteArticleOptionsForArticle(articleId);
  }

  public int deleteArticleOptionsForArticleGroup(String articleGroupId) {
    return BEANS.get(IArticleOptionRepository.class).deleteArticleOptionsForArticleGroup(articleGroupId);
  }
}
