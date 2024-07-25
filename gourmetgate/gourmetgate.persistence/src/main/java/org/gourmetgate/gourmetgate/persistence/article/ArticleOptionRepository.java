package org.gourmetgate.gourmetgate.persistence.article;

import org.gourmetgate.gourmetgate.data.article.ArticleOptionDo;
import org.gourmetgate.gourmetgate.data.article.IArticleOptionRepository;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleOptionRecord;
import org.jooq.Field;

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
  protected DoEntityBeanMappings<ArticleOptionDo, ArticleOptionRecord> mappings() {
    return new DoEntityBeanMappings<ArticleOptionDo, ArticleOptionRecord>()
      .with(ArticleOptionDo::articleOptionId, ArticleOptionRecord::getArticleOptionId, ArticleOptionRecord::setArticleOptionId)
      .with(ArticleOptionDo::articleId, ArticleOptionRecord::getArticleId, ArticleOptionRecord::setArticleId)
      .with(ArticleOptionDo::description, ArticleOptionRecord::getDescription, ArticleOptionRecord::setDescription);
  }
}
