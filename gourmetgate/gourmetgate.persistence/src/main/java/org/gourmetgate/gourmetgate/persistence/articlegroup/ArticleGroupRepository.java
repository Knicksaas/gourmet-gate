package org.gourmetgate.gourmetgate.persistence.articlegroup;

import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.articlegroup.IArticleGroupRepository;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleGroup;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleGroupRecord;
import org.jooq.Field;

public class ArticleGroupRepository extends AbstractRepository<ArticleGroup, ArticleGroupRecord, ArticleGroupDo> implements IArticleGroupRepository {

  @Override
  public ArticleGroup getTable() {
    return ArticleGroup.ARTICLE_GROUP;
  }

  @Override
  public Field<String> getIdColumn() {
    return ArticleGroup.ARTICLE_GROUP.ARTICLE_GROUP_ID;
  }

  @Override
  protected Field<String> getTextColumn() {
    return getTable().NAME;
  }

  @Override
  protected DoEntityBeanMappings<ArticleGroupDo, ArticleGroupRecord> mappings() {
    return new DoEntityBeanMappings<ArticleGroupDo, ArticleGroupRecord>()
      .with(ArticleGroupDo::articleGroupId, ArticleGroupRecord::getArticleGroupId, ArticleGroupRecord::setArticleGroupId)
      .with(ArticleGroupDo::name, ArticleGroupRecord::getName, ArticleGroupRecord::setName)
      .with(ArticleGroupDo::enabled, ArticleGroupRecord::getEnabled, ArticleGroupRecord::setEnabled);
  }
}
