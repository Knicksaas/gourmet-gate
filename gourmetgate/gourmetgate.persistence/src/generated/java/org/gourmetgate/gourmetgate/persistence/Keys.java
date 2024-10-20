/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence;


import org.gourmetgate.gourmetgate.persistence.tables.Article;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleGroup;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.EventLog;
import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPosition;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.gourmetgate.gourmetgate.persistence.tables.Parameter;
import org.gourmetgate.gourmetgate.persistence.tables.Payment;
import org.gourmetgate.gourmetgate.persistence.tables.Person;
import org.gourmetgate.gourmetgate.persistence.tables.Table;
import org.gourmetgate.gourmetgate.persistence.tables.User;
import org.gourmetgate.gourmetgate.persistence.tables.Vat;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleGroupRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleOptionRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.ArticleRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.EventLogRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionOptionRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderPositionRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.OrderRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.ParameterRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.PaymentRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.PersonRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.TableRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.UserRecord;
import org.gourmetgate.gourmetgate.persistence.tables.records.VatRecord;
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
  public static final UniqueKey<ArticleGroupRecord> ARTICLE_GROUP_PK = Internal.createUniqueKey(ArticleGroup.ARTICLE_GROUP, DSL.name("ARTICLE_GROUP_PK"), new TableField[]{ArticleGroup.ARTICLE_GROUP.ARTICLE_GROUP_ID}, true);
  public static final UniqueKey<ArticleOptionRecord> ARTICLE_OPTION_PK = Internal.createUniqueKey(ArticleOption.ARTICLE_OPTION, DSL.name("ARTICLE_OPTION_PK"), new TableField[]{ArticleOption.ARTICLE_OPTION.ARTICLE_OPTION_ID}, true);
  public static final UniqueKey<EventLogRecord> EVENT_LOG_PK = Internal.createUniqueKey(EventLog.EVENT_LOG, DSL.name("EVENT_LOG_PK"), new TableField[]{EventLog.EVENT_LOG.EVENT_LOG_ID}, true);
  public static final UniqueKey<OrderRecord> ORDER_PK = Internal.createUniqueKey(Order.ORDER, DSL.name("ORDER_PK"), new TableField[]{Order.ORDER.ORDER_ID}, true);
  public static final UniqueKey<OrderPositionRecord> ORDER_POSITION_PK = Internal.createUniqueKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_PK"), new TableField[]{OrderPosition.ORDER_POSITION.ORDER_POSITION_ID}, true);
  public static final UniqueKey<OrderPositionOptionRecord> ORDER_POSITION_OPTION_PK = Internal.createUniqueKey(OrderPositionOption.ORDER_POSITION_OPTION, DSL.name("ORDER_POSITION_OPTION_PK"), new TableField[]{OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_OPTION_ID}, true);
  public static final UniqueKey<ParameterRecord> PARAMETER_PK = Internal.createUniqueKey(Parameter.PARAMETER, DSL.name("PARAMETER_PK"), new TableField[]{Parameter.PARAMETER.PARAMETER_ID}, true);
  public static final UniqueKey<ParameterRecord> PARAMETER_PK_2 = Internal.createUniqueKey(Parameter.PARAMETER, DSL.name("PARAMETER_PK_2"), new TableField[]{Parameter.PARAMETER.NAME}, true);
  public static final UniqueKey<PaymentRecord> PAYMENT_PK = Internal.createUniqueKey(Payment.PAYMENT, DSL.name("PAYMENT_PK"), new TableField[]{Payment.PAYMENT.PAYMENT_ID}, true);
    public static final UniqueKey<PersonRecord> PERSON_PK = Internal.createUniqueKey(Person.PERSON, DSL.name("person_pk"), new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final UniqueKey<TableRecord> TABLE_PK = Internal.createUniqueKey(Table.TABLE, DSL.name("TABLE_PK"), new TableField[] { Table.TABLE.TABLE_ID }, true);
  public static final UniqueKey<UserRecord> USER_PK = Internal.createUniqueKey(User.USER, DSL.name("USER_PK"), new TableField[]{User.USER.USER_ID}, true);
  public static final UniqueKey<UserRecord> USER_PK_2 = Internal.createUniqueKey(User.USER, DSL.name("USER_PK_2"), new TableField[]{User.USER.USER_NAME}, true);
  public static final UniqueKey<VatRecord> VAT_PK = Internal.createUniqueKey(Vat.VAT, DSL.name("VAT_PK"), new TableField[]{Vat.VAT.VAT_ID}, true);

  // -------------------------------------------------------------------------
  // FOREIGN KEY definitions
  // -------------------------------------------------------------------------

  public static final ForeignKey<ArticleRecord, ArticleGroupRecord> ARTICLE_ARTICLE_GROUP_ARTICLE_GROUP_ID_FK = Internal.createForeignKey(Article.ARTICLE, DSL.name("ARTICLE_ARTICLE_GROUP_ARTICLE_GROUP_ID_FK"), new TableField[]{Article.ARTICLE.ARTICLE_GROUP_ID}, Keys.ARTICLE_GROUP_PK, new TableField[]{ArticleGroup.ARTICLE_GROUP.ARTICLE_GROUP_ID}, true);
  public static final ForeignKey<ArticleRecord, VatRecord> ARTICLE_VAT_VAT_ID_FK = Internal.createForeignKey(Article.ARTICLE, DSL.name("ARTICLE_VAT_VAT_ID_FK"), new TableField[]{Article.ARTICLE.VAT_ID}, Keys.VAT_PK, new TableField[]{Vat.VAT.VAT_ID}, true);
  public static final ForeignKey<ArticleOptionRecord, ArticleRecord> ARTICLE_OPTION_ARTICLE_ARTICLE_ID_FK = Internal.createForeignKey(ArticleOption.ARTICLE_OPTION, DSL.name("ARTICLE_OPTION_ARTICLE_ARTICLE_ID_FK"), new TableField[]{ArticleOption.ARTICLE_OPTION.ARTICLE_ID}, Keys.ARTICLE_PK, new TableField[]{Article.ARTICLE.ARTICLE_ID}, true);
  public static final ForeignKey<OrderRecord, TableRecord> ORDER_TABLE_TABLE_ID_FK = Internal.createForeignKey(Order.ORDER, DSL.name("ORDER_TABLE_TABLE_ID_FK"), new TableField[]{Order.ORDER.TABLE_ID}, Keys.TABLE_PK, new TableField[]{Table.TABLE.TABLE_ID}, true);
  public static final ForeignKey<OrderPositionRecord, ArticleRecord> ORDER_POSITION_ARTICLE_ARTICLE_ID_FK = Internal.createForeignKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_ARTICLE_ARTICLE_ID_FK"), new TableField[]{OrderPosition.ORDER_POSITION.ARTICLE_ID}, Keys.ARTICLE_PK, new TableField[]{Article.ARTICLE.ARTICLE_ID}, true);
  public static final ForeignKey<OrderPositionRecord, OrderRecord> ORDER_POSITION_ORDER_ORDER_ID_FK = Internal.createForeignKey(OrderPosition.ORDER_POSITION, DSL.name("ORDER_POSITION_ORDER_ORDER_ID_FK"), new TableField[]{OrderPosition.ORDER_POSITION.ORDER_ID}, Keys.ORDER_PK, new TableField[]{Order.ORDER.ORDER_ID}, true);
  public static final ForeignKey<OrderPositionOptionRecord, ArticleOptionRecord> ORDER_POSITION_OPTION_ARTICLE_OPTION_ARTICLE_OPTION_ID_FK = Internal.createForeignKey(OrderPositionOption.ORDER_POSITION_OPTION, DSL.name("ORDER_POSITION_OPTION_ARTICLE_OPTION_ARTICLE_OPTION_ID_FK"), new TableField[]{OrderPositionOption.ORDER_POSITION_OPTION.ARTICLE_OPTION_ID}, Keys.ARTICLE_OPTION_PK, new TableField[]{ArticleOption.ARTICLE_OPTION.ARTICLE_OPTION_ID}, true);
  public static final ForeignKey<OrderPositionOptionRecord, OrderPositionRecord> ORDER_POSITION_OPTION_ORDER_POSITION_ORDER_POSITION_ID_FK = Internal.createForeignKey(OrderPositionOption.ORDER_POSITION_OPTION, DSL.name("ORDER_POSITION_OPTION_ORDER_POSITION_ORDER_POSITION_ID_FK"), new TableField[]{OrderPositionOption.ORDER_POSITION_OPTION.ORDER_POSITION_ID}, Keys.ORDER_POSITION_PK, new TableField[]{OrderPosition.ORDER_POSITION.ORDER_POSITION_ID}, true);
  public static final ForeignKey<PaymentRecord, OrderRecord> PAYMENT_ORDER_ORDER_ID_FK = Internal.createForeignKey(Payment.PAYMENT, DSL.name("PAYMENT_ORDER_ORDER_ID_FK"), new TableField[]{Payment.PAYMENT.ORDER_ID}, Keys.ORDER_PK, new TableField[]{Order.ORDER.ORDER_ID}, true);
}
