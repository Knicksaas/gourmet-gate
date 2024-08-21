package org.gourmetgate.gourmetgate.persistence.article;

import org.gourmetgate.gourmetgate.data.article.ArticleOptionDo;
import org.gourmetgate.gourmetgate.data.article.IArticleOptionRepository;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Article;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleOptionRecord;
import org.jooq.Field;

import java.util.stream.Stream;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.select;

public class ArticleOptionRepository extends AbstractRepository<ArticleOption, ArticleOptionRecord, ArticleOptionDo> implements IArticleOptionRepository {

  @Override
  public ArticleOption getTable() {
    return ArticleOption.ARTICLE_OPTION;
  }

  @Override
  public Field<String> getIdColumn() {
    return ArticleOption.ARTICLE_OPTION.ARTICLE_OPTION_ID;
  }

  @Override
  public Stream<ArticleOptionDo> getArticleOptionsForArticle(String articleId) {
    return jooq()
      .selectFrom(getTable())
      .where(ArticleOption.ARTICLE_OPTION.ARTICLE_ID.eq(articleId))
      .stream()
      .map(this::fromRecordToDo);
  }

  @Override
  public int deleteArticleOptionsForArticle(String articleId) {
    return jooq()
      .deleteFrom(getTable())
      .where(getTable().ARTICLE_ID.eq(articleId))
      .execute();
  }

  @Override
  public int deleteArticleOptionsForArticleGroup(String articleGroupId) {
    return jooq()
      .deleteFrom(getTable())
      .where(getTable().ARTICLE_ID.in(
        select(Article.ARTICLE.ARTICLE_ID)
          .from(Article.ARTICLE)
          .where(Article.ARTICLE.ARTICLE_GROUP_ID.eq(articleGroupId))))
      .execute();
  }

  @Override
  protected DoEntityBeanMappings<ArticleOptionDo, ArticleOptionRecord> mappings() {
    return new DoEntityBeanMappings<ArticleOptionDo, ArticleOptionRecord>()
      .with(ArticleOptionDo::articleOptionId, ArticleOptionRecord::getArticleOptionId, ArticleOptionRecord::setArticleOptionId)
      .with(ArticleOptionDo::articleId, ArticleOptionRecord::getArticleId, ArticleOptionRecord::setArticleId)
      .with(ArticleOptionDo::description, ArticleOptionRecord::getDescription, ArticleOptionRecord::setDescription);
  }
}
