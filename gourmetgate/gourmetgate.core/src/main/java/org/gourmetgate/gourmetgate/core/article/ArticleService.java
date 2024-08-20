package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.ArticleTablePageEntryDo;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;

import java.util.stream.Stream;

public class ArticleService implements IService {

  public Stream<ArticleDo> all() {
    return BEANS.get(IArticleRepository.class).all();
  }

  public Stream<ArticleTablePageEntryDo> getArticelTablePageData() {
    return Stream.concat(
      BEANS.get(ArticleGroupService.class).all().map(this::translateArticleGroup),
      BEANS.get(ArticleService.class).all().map(this::translateArticle)
    );
  }

  protected ArticleTablePageEntryDo translateArticleGroup(ArticleGroupDo articleGroup) {
    return BEANS.get(ArticleTablePageEntryDo.class)
      .withId(articleGroup.getArticleGroupId())
      .withName(articleGroup.getName())
      .withEnabled(articleGroup.getEnabled());
  }

  protected ArticleTablePageEntryDo translateArticle(ArticleDo article) {
    return BEANS.get(ArticleTablePageEntryDo.class)
      .withId(article.getArticleId())
      .withParentId(article.getArticleGroupId())
      .withName(article.getName())
      .withUnit(article.getUnit())
      .withPrice(article.getPrice())
      .withOptions(article.getOptions())
      .withEnabled(article.isEnabled());
  }
}
