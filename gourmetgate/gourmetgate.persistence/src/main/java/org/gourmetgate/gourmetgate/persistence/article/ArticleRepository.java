package org.gourmetgate.gourmetgate.persistence.article;

import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.Article;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleRecord;
import org.jooq.Field;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class ArticleRepository extends AbstractRepository<Article, ArticleRecord, ArticleDo> implements IArticleRepository {

  @Override
  public Article getTable() {
    return Article.ARTICLE;
  }

  @Override
  public Field<String> getIdColumn() {
    return Article.ARTICLE.ARTICLE_ID;
  }

  @Override
  public int deleteByGroupId(String articleGroupId) {
    return jooq()
      .deleteFrom(getTable())
      .where(getTable().ARTICLE_GROUP_ID.eq(articleGroupId))
      .execute();
  }

  @Override
  protected DoEntityBeanMappings<ArticleDo, ArticleRecord> mappings() {
    return new DoEntityBeanMappings<ArticleDo, ArticleRecord>()
      .with(ArticleDo::articleId, ArticleRecord::getArticleId, ArticleRecord::setArticleId)
      .with(ArticleDo::articleGroupId, ArticleRecord::getArticleGroupId, ArticleRecord::setArticleGroupId)
      .with(ArticleDo::name, ArticleRecord::getName, ArticleRecord::setName)
      .with(ArticleDo::unit, ArticleRecord::getUnit, ArticleRecord::setUnit)
      .with(ArticleDo::price, ArticleRecord::getPrice, ArticleRecord::setPrice)
      .with(ArticleDo::options, ArticleRecord::getHasOptions, ArticleRecord::setHasOptions)
      .with(ArticleDo::vatId, ArticleRecord::getVatId, ArticleRecord::setVatId)
      .with(ArticleDo::enabled, ArticleRecord::getEnabled, ArticleRecord::setEnabled);
  }
}
