package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.*;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.articlegroup.IArticleGroupRepository;
import org.gourmetgate.gourmetgate.data.dataprovider.IArticleGroupProvider;
import org.gourmetgate.gourmetgate.data.dataprovider.IArticleProvider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ArticleService implements IService {

  public Stream<ArticleDo> all() {
    return BEANS.get(IArticleRepository.class).all();
  }

  public Stream<ArticleDo> allEnabled() {
    return BEANS.get(IArticleRepository.class).allEnabled();
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

  public ArticleDo createArticle(ArticleDo article) {
    List<ArticleOptionDo> articleOptions = article.getArticleOptions();
    ArticleDo newArticle = BEANS.get(IArticleRepository.class).create(article);
    articleOptions.forEach(articleOptionDo -> articleOptionDo.withArticleId(newArticle.getArticleId()));
    List<ArticleOptionDo> newArticleOptions = BEANS.get(ArticleOptionService.class).createArticleOptions(articleOptions).toList();
    return newArticle.withArticleOptions(newArticleOptions);
  }

  public ArticleDo getArticleById(String articleId) {
    return BEANS.get(IArticleRepository.class)
      .getById(articleId)
      .map(article -> {
        if (article.isOptions()) {
          article.withArticleOptions(BEANS.get(ArticleOptionService.class)
            .getArticleOptionForArticle(article.getArticleId())
            .toList());
        }
        return article;
      })
      .orElse(null);
  }

  public void updateArticle(String id, ArticleDo article) {
    BEANS.get(IArticleRepository.class).update(id, article);
    BEANS.get(ArticleOptionService.class).updateArticleOptions(article.getArticleId(), article.getArticleOptions());
  }

  public int deleteArticle(String articleId) {
    BEANS.get(ArticleOptionService.class).deleteArticleOptionsForArticle(articleId);
    return BEANS.get(IArticleRepository.class).delete(articleId);
  }

  public void syncArticlesFromLoyverse() {
    List<ArticleGroupDo> newGroups = BEANS.get(IArticleGroupProvider.class).getArticleGroups();
    List<ArticleDo> newArticles = BEANS.get(IArticleProvider.class).getArticles();
    List<ArticleOptionDo> newArticleOptions = newArticles.stream()
      .filter(ArticleDo::isOptions)
      .map(ArticleDo::getArticleOptions)
      .flatMap(Collection::stream)
      .toList();

    IArticleGroupRepository groupRepository = BEANS.get(IArticleGroupRepository.class);
    IArticleRepository articleRepository = BEANS.get(IArticleRepository.class);
    IArticleOptionRepository optionRepository = BEANS.get(IArticleOptionRepository.class);

    // Insert or update new groups and articles
    newGroups.forEach(group -> groupRepository.update(group.getArticleGroupId(), group));
    newArticles.forEach(article -> articleRepository.update(article.getArticleId(), article));
    newArticleOptions.forEach(option -> optionRepository.update(option.getArticleOptionId(), option));
  }
}
