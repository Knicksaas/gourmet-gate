package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.articlegroup.IArticleGroupRepository;

import java.util.Optional;
import java.util.stream.Stream;

public class ArticleGroupService implements IService {

  public Stream<ArticleGroupDo> all() {
    return BEANS.get(IArticleGroupRepository.class).all();
  }

  public ArticleGroupDo createArticleGroup(ArticleGroupDo articleGroupDo) {
    return BEANS.get(IArticleGroupRepository.class).create(articleGroupDo);
  }

  public Optional<ArticleGroupDo> getArticleGroup(String articleGroupId) {
    return BEANS.get(IArticleGroupRepository.class).getById(articleGroupId);
  }

  public boolean deleteArticleGroup(String articleGroupId) {
    return BEANS.get(IArticleGroupRepository.class).delete(articleGroupId) == 1;
  }

  public void updateArticleGroup(String articleGroupId, ArticleGroupDo articleGroupDo) {
    BEANS.get(IArticleGroupRepository.class).update(articleGroupId, articleGroupDo);
  }
}
