package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.IArticleOptionRepository;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.articlegroup.IArticleGroupRepository;
import org.gourmetgate.gourmetgate.data.lookup.LookupRestrictionDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupResultDo;
import org.gourmetgate.gourmetgate.data.lookup.LookupRowDo;

import java.util.List;
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

  public void updateArticleGroup(String articleGroupId, ArticleGroupDo articleGroupDo) {
    BEANS.get(IArticleGroupRepository.class).update(articleGroupId, articleGroupDo);
  }

  public boolean deleteArticleGroup(String articleGroupId) {
    BEANS.get(IArticleOptionRepository.class).deleteArticleOptionsForArticleGroup(articleGroupId);
    BEANS.get(IArticleRepository.class).deleteByGroupId(articleGroupId);
    return BEANS.get(IArticleGroupRepository.class).delete(articleGroupId) == 1;
  }

  public LookupResultDo lookupArticleGroup(LookupRestrictionDo restriction) {
    LookupResultDo result = BEANS.get(LookupResultDo.class);
    List<LookupRowDo> lookupRows = BEANS.get(IArticleGroupRepository.class).search(restriction)
      .map(this::fromDoToLookupRow)
      .toList();
    result.withRows(lookupRows);
    return result;
  }

  protected LookupRowDo fromDoToLookupRow(ArticleGroupDo group) {
    return BEANS.get(LookupRowDo.class)
      .withId(group.getArticleGroupId())
      .withText(group.getName())
      .withActive(group.getEnabled());
  }
}
