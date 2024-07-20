/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence;


import org.gourmetgate.gourmetgate.persistence.tables.*;
import org.gourmetgate.gourmetgate.persistence.tables.records.*;
import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * Schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

  public static final UniqueKey<ArticleRecord> ARTICLE_PK = Internal.createUniqueKey(Article.ARTICLE, DSL.name("ARTICLE_PK"), new TableField[]{Article.ARTICLE.ARTICLE_ID}, true);
  public static final UniqueKey<OrderRecord> ORDER_PK = Internal.createUniqueKey(Order.ORDER, DSL.name("ORDER_PK"), new TableField[]{Order.ORDER.ORDER_ID}, true);
  public static final UniqueKey<OrderPositionRecord> ORDER_POSITION_PK = Internal.createUniqueKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_PK"), new TableField[]{OrderPosition.ORDER_POSITION.ORDER_POSITION_ID}, true);
    public static final UniqueKey<PersonRecord> PERSON_PK = Internal.createUniqueKey(Person.PERSON, DSL.name("person_pk"), new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final UniqueKey<TableRecord> TABLE_PK = Internal.createUniqueKey(Table.TABLE, DSL.name("TABLE_PK"), new TableField[] { Table.TABLE.TABLE_ID }, true);
  public static final UniqueKey<VatRecord> VAT_PK = Internal.createUniqueKey(Vat.VAT, DSL.name("VAT_PK"), new TableField[]{Vat.VAT.VAT_ID}, true);

  // -------------------------------------------------------------------------
  // FOREIGN KEY definitions
  // -------------------------------------------------------------------------

  public static final ForeignKey<ArticleRecord, VatRecord> ARTICLE_VAT_VAT_ID_FK = Internal.createForeignKey(Article.ARTICLE, DSL.name("ARTICLE_VAT_VAT_ID_FK"), new TableField[]{Article.ARTICLE.VAT_ID}, Keys.VAT_PK, new TableField[]{Vat.VAT.VAT_ID}, true);
  public static final ForeignKey<OrderRecord, TableRecord> ORDER_TABLE_TABLE_ID_FK = Internal.createForeignKey(Order.ORDER, DSL.name("ORDER_TABLE_TABLE_ID_FK"), new TableField[]{Order.ORDER.TABLE_ID}, Keys.TABLE_PK, new TableField[]{Table.TABLE.TABLE_ID}, true);
  public static final ForeignKey<OrderPositionRecord, ArticleRecord> ORDER_POSITION_ARTICLE_ARTICLE_ID_FK = Internal.createForeignKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_ARTICLE_ARTICLE_ID_FK"), new TableField[]{OrderPosition.ORDER_POSITION.ARTICLE_ID}, Keys.ARTICLE_PK, new TableField[]{Article.ARTICLE.ARTICLE_ID}, true);
  public static final ForeignKey<OrderPositionRecord, OrderRecord> ORDER_POSITION_ORDER_ORDER_ID_FK = Internal.createForeignKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_ORDER_ORDER_ID_FK"), new TableField[]{OrderPosition.ORDER_POSITION.ORDER_ID}, Keys.ORDER_PK, new TableField[]{Order.ORDER.ORDER_ID}, true);
}
