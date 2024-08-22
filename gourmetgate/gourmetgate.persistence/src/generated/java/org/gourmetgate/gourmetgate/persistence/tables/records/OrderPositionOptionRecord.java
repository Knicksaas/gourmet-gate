/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables.records;


import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OrderPositionOptionRecord extends UpdatableRecordImpl<OrderPositionOptionRecord> implements Record5<String, String, String, Boolean, String> {

  private static final long serialVersionUID = 1L;

  /**
   * Setter for
   * <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID</code>.
   */
  public void setOrderPositionOptionId(String value) {
    set(0, value);
  }

    /**
     * Getter for
     * <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID</code>.
     */
    public String getOrderPositionOptionId() {
      return (String) get(0);
    }

    /**
     * Setter for <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_ID</code>.
     */
    public void setOrderPositionId(String value) {
      set(1, value);
    }

    /**
     * Getter for <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_ID</code>.
     */
    public String getOrderPositionId() {
      return (String) get(1);
    }

    /**
     * Setter for <code>Schema.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID</code>.
     */
    public void setArticleOptionId(String value) {
      set(2, value);
    }

    /**
     * Getter for <code>Schema.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID</code>.
     */
    public String getArticleOptionId() {
      return (String) get(2);
    }

    /**
     * Setter for <code>Schema.ORDER_POSITION_OPTION.SELECTED</code>.
     */
    public void setSelected(Boolean value) {
      set(3, value);
    }

  /**
   * Getter for <code>Schema.ORDER_POSITION_OPTION.SELECTED</code>.
   */
  public Boolean getSelected() {
    return (Boolean) get(3);
  }

  /**
   * Setter for <code>Schema.ORDER_POSITION_OPTION.DESCRIPTION</code>.
   */
  public void setDescription(String value) {
    set(4, value);
  }

  /**
   * Getter for <code>Schema.ORDER_POSITION_OPTION.DESCRIPTION</code>.
   */
  public String getDescription() {
    return (String) get(4);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<String> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record5 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row5<String, String, String, Boolean, String> fieldsRow() {
    return (Row5) super.fieldsRow();
  }

  @Override
  public Row5<String, String, String, Boolean, String> valuesRow() {
    return (Row5) super.valuesRow();
  }

  @Override
  public Field<String> field1() {
    return OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID;
  }

  @Override
  public Field<String> field2() {
    return OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_ID;
  }

  @Override
  public Field<String> field3() {
    return OrderPositionOption.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID;
  }

  @Override
  public Field<Boolean> field4() {
    return OrderPositionOption.ORDER_POSITION_OPTION.SELECTED;
  }

  @Override
  public Field<String> field5() {
    return OrderPositionOption.ORDER_POSITION_OPTION.DESCRIPTION;
  }

  @Override
  public String component1() {
    return getOrderPositionOptionId();
  }

  @Override
  public String component2() {
    return getOrderPositionId();
  }

  @Override
  public String component3() {
    return getArticleOptionId();
  }

  @Override
  public Boolean component4() {
    return getSelected();
  }

  @Override
  public String component5() {
    return getDescription();
  }

  @Override
  public String value1() {
    return getOrderPositionOptionId();
  }

  @Override
  public String value2() {
    return getOrderPositionId();
  }

  @Override
  public String value3() {
    return getArticleOptionId();
  }

  @Override
  public Boolean value4() {
    return getSelected();
  }

  @Override
  public String value5() {
    return getDescription();
  }

  @Override
  public OrderPositionOptionRecord value1(String value) {
    setOrderPositionOptionId(value);
    return this;
  }

  @Override
  public OrderPositionOptionRecord value2(String value) {
    setOrderPositionId(value);
    return this;
  }

  @Override
  public OrderPositionOptionRecord value3(String value) {
    setArticleOptionId(value);
    return this;
  }

  @Override
  public OrderPositionOptionRecord value4(Boolean value) {
    setSelected(value);
    return this;
  }

  @Override
  public OrderPositionOptionRecord value5(String value) {
    setDescription(value);
    return this;
  }

  @Override
  public OrderPositionOptionRecord values(String value1, String value2, String value3, Boolean value4, String value5) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    value5(value5);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /**
   * Create a detached OrderPositionOptionRecord
   */
  public OrderPositionOptionRecord() {
    super(OrderPositionOption.ORDER_POSITION_OPTION);
  }

  /**
   * Create a detached, initialised OrderPositionOptionRecord
   */
  public OrderPositionOptionRecord(String orderPositionOptionId, String orderPositionId, String articleOptionId, Boolean selected, String description) {
    super(OrderPositionOption.ORDER_POSITION_OPTION);

    setOrderPositionOptionId(orderPositionOptionId);
    setOrderPositionId(orderPositionId);
    setArticleOptionId(articleOptionId);
    setSelected(selected);
    setDescription(description);
  }
}
