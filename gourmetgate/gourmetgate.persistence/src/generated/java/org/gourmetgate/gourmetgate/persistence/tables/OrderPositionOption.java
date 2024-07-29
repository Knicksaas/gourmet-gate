/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables;


import org.gourmetgate.gourmetgate.persistence.Keys;
import org.gourmetgate.gourmetgate.persistence.Schema;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionOptionRecord;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OrderPositionOption extends TableImpl<OrderPositionOptionRecord> {

  private static final long serialVersionUID = 1L;

  /**
   * The reference instance of <code>Schema.ORDER_POSITION_OPTION</code>
   */
  public static final OrderPositionOption ORDER_POSITION_OPTION = new OrderPositionOption();

  /**
   * The class holding records for this type
   */
  @Override
  public Class<OrderPositionOptionRecord> getRecordType() {
    return OrderPositionOptionRecord.class;
  }

  /**
   * The column
   * <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID</code>.
   */
  public final TableField<OrderPositionOptionRecord, String> ORDER_POSITION_OPTION_ID = createField(DSL.name("ORDER_POSITION_OPTION_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.ORDER_POSITION_OPTION.ORDER_POSITION_ID</code>.
   */
  public final TableField<OrderPositionOptionRecord, String> ORDER_POSITION_ID = createField(DSL.name("ORDER_POSITION_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID</code>.
   */
  public final TableField<OrderPositionOptionRecord, String> ARTICLE_OPTION_ID = createField(DSL.name("ARTICLE_OPTION_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

  /**
   * The column <code>Schema.ORDER_POSITION_OPTION.SELECTED</code>.
   */
  public final TableField<OrderPositionOptionRecord, Boolean> SELECTED = createField(DSL.name("SELECTED"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("FALSE", SQLDataType.BOOLEAN)), this, "");

  private OrderPositionOption(Name alias, Table<OrderPositionOptionRecord> aliased) {
    this(alias, aliased, null);
  }

  private OrderPositionOption(Name alias, Table<OrderPositionOptionRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /**
   * Create an aliased <code>Schema.ORDER_POSITION_OPTION</code> table
   * reference
   */
  public OrderPositionOption(String alias) {
    this(DSL.name(alias), ORDER_POSITION_OPTION);
  }

  /**
   * Create an aliased <code>Schema.ORDER_POSITION_OPTION</code> table
   * reference
   */
  public OrderPositionOption(Name alias) {
    this(alias, ORDER_POSITION_OPTION);
  }

  /**
   * Create a <code>Schema.ORDER_POSITION_OPTION</code> table reference
   */
  public OrderPositionOption() {
    this(DSL.name("ORDER_POSITION_OPTION"), null);
  }

  public <O extends Record> OrderPositionOption(Table<O> child, ForeignKey<O, OrderPositionOptionRecord> key) {
    super(child, key, ORDER_POSITION_OPTION);
  }

  @Override
  public org.jooq.Schema getSchema() {
    return aliased() ? null : Schema.SCHEMA;
  }

  @Override
  public UniqueKey<OrderPositionOptionRecord> getPrimaryKey() {
    return Keys.ORDER_POSITION_OPTION_PK;
  }

  @Override
  public List<ForeignKey<OrderPositionOptionRecord, ?>> getReferences() {
    return Arrays.asList(Keys.ORDER_POSITION_OPTION_ORDER_POSITION_ORDER_POSITION_ID_FK, Keys.ORDER_POSITION_OPTION_ARTICLE_OPTION_ARTICLE_OPTION_ID_FK);
  }

  private transient OrderPosition _orderPosition;
  private transient ArticleOption _articleOption;

  /**
   * Get the implicit join path to the <code>Schema.ORDER_POSITION</code>
   * table.
   */
  public OrderPosition orderPosition() {
    if (_orderPosition == null)
      _orderPosition = new OrderPosition(this, Keys.ORDER_POSITION_OPTION_ORDER_POSITION_ORDER_POSITION_ID_FK);

    return _orderPosition;
  }

  /**
   * Get the implicit join path to the <code>Schema.ARTICLE_OPTION</code>
   * table.
   */
  public ArticleOption articleOption() {
    if (_articleOption == null)
      _articleOption = new ArticleOption(this, Keys.ORDER_POSITION_OPTION_ARTICLE_OPTION_ARTICLE_OPTION_ID_FK);

    return _articleOption;
  }

  @Override
  public OrderPositionOption as(String alias) {
    return new OrderPositionOption(DSL.name(alias), this);
  }

  @Override
    public OrderPositionOption as(Name alias) {
    return new OrderPositionOption(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public OrderPositionOption rename(String name) {
    return new OrderPositionOption(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public OrderPositionOption rename(Name name) {
    return new OrderPositionOption(name, null);
  }

  // -------------------------------------------------------------------------
  // Row4 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row4<String, String, String, Boolean> fieldsRow() {
    return (Row4) super.fieldsRow();
  }
}
