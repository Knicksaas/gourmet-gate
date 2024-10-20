/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables.records;


import org.gourmetgate.gourmetgate.persistence.tables.ArticleGroup;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ArticleGroupRecord extends UpdatableRecordImpl<ArticleGroupRecord> implements Record3<String, String, Boolean> {

  private static final long serialVersionUID = 1L;

  /**
   * Setter for <code>Schema.ARTICLE_GROUP.ARTICLE_GROUP_ID</code>.
   */
  public void setArticleGroupId(String value) {
    set(0, value);
  }

  /**
   * Getter for <code>Schema.ARTICLE_GROUP.ARTICLE_GROUP_ID</code>.
   */
  public String getArticleGroupId() {
    return (String) get(0);
  }

  /**
   * Setter for <code>Schema.ARTICLE_GROUP.NAME</code>.
   */
  public void setName(String value) {
    set(1, value);
  }

  /**
   * Getter for <code>Schema.ARTICLE_GROUP.NAME</code>.
   */
  public String getName() {
    return (String) get(1);
  }

  /**
   * Setter for <code>Schema.ARTICLE_GROUP.ENABLED</code>.
   */
  public void setEnabled(Boolean value) {
    set(2, value);
  }

  /**
   * Getter for <code>Schema.ARTICLE_GROUP.ENABLED</code>.
   */
  public Boolean getEnabled() {
    return (Boolean) get(2);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<String> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record3 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row3<String, String, Boolean> fieldsRow() {
    return (Row3) super.fieldsRow();
  }

  @Override
  public Row3<String, String, Boolean> valuesRow() {
    return (Row3) super.valuesRow();
  }

  @Override
  public Field<String> field1() {
    return ArticleGroup.ARTICLE_GROUP.ARTICLE_GROUP_ID;
  }

  @Override
  public Field<String> field2() {
    return ArticleGroup.ARTICLE_GROUP.NAME;
  }

  @Override
  public Field<Boolean> field3() {
    return ArticleGroup.ARTICLE_GROUP.ENABLED;
  }

  @Override
  public String component1() {
    return getArticleGroupId();
  }

  @Override
  public String component2() {
    return getName();
  }

  @Override
  public Boolean component3() {
    return getEnabled();
  }

  @Override
  public String value1() {
    return getArticleGroupId();
  }

  @Override
  public String value2() {
    return getName();
  }

  @Override
  public Boolean value3() {
    return getEnabled();
  }

  @Override
  public ArticleGroupRecord value1(String value) {
    setArticleGroupId(value);
    return this;
  }

  @Override
  public ArticleGroupRecord value2(String value) {
    setName(value);
    return this;
  }

  @Override
  public ArticleGroupRecord value3(Boolean value) {
    setEnabled(value);
    return this;
  }

  @Override
  public ArticleGroupRecord values(String value1, String value2, Boolean value3) {
    value1(value1);
    value2(value2);
    value3(value3);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /**
   * Create a detached ArticleGroupRecord
   */
  public ArticleGroupRecord() {
    super(ArticleGroup.ARTICLE_GROUP);
  }

  /**
   * Create a detached, initialised ArticleGroupRecord
   */
  public ArticleGroupRecord(String articleGroupId, String name, Boolean enabled) {
    super(ArticleGroup.ARTICLE_GROUP);

    setArticleGroupId(articleGroupId);
    setName(name);
    setEnabled(enabled);
  }
}
