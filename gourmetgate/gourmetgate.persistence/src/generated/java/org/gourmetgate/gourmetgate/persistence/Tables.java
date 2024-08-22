/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence;


import org.gourmetgate.gourmetgate.persistence.tables.Article;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleGroup;
import org.gourmetgate.gourmetgate.persistence.tables.ArticleOption;
import org.gourmetgate.gourmetgate.persistence.tables.Order;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPosition;
import org.gourmetgate.gourmetgate.persistence.tables.OrderPositionOption;
import org.gourmetgate.gourmetgate.persistence.tables.Payment;
import org.gourmetgate.gourmetgate.persistence.tables.Person;
import org.gourmetgate.gourmetgate.persistence.tables.Table;
import org.gourmetgate.gourmetgate.persistence.tables.User;
import org.gourmetgate.gourmetgate.persistence.tables.Vat;


/**
 * Convenience access to all tables in Schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

  /**
   * The table <code>Schema.ARTICLE</code>.
   */
  public static final Article ARTICLE = Article.ARTICLE;

  /**
   * The table <code>Schema.ARTICLE_GROUP</code>.
   */
  public static final ArticleGroup ARTICLE_GROUP = ArticleGroup.ARTICLE_GROUP;

  /**
   * The table <code>Schema.ARTICLE_OPTION</code>.
   */
  public static final ArticleOption ARTICLE_OPTION = ArticleOption.ARTICLE_OPTION;

  /**
   * The table <code>Schema.order</code>.
   */
  public static final Order ORDER = Order.ORDER;

  /**
   * The table <code>Schema.ORDER_POSITION</code>.
   */
  public static final OrderPosition ORDER_POSITION = OrderPosition.ORDER_POSITION;

  /**
   * The table <code>Schema.ORDER_POSITION_OPTION</code>.
   */
  public static final OrderPositionOption ORDER_POSITION_OPTION = OrderPositionOption.ORDER_POSITION_OPTION;

  /**
   * The table <code>Schema.PAYMENT</code>.
   */
  public static final Payment PAYMENT = Payment.PAYMENT;

  /**
   * The table <code>Schema.person</code>.
   */
  public static final Person PERSON = Person.PERSON;

  /**
   * The table <code>Schema.table</code>.
   */
  public static final Table TABLE = Table.TABLE;

  /**
   * The table <code>Schema.user</code>.
   */
  public static final User USER = User.USER;

  /**
   * The table <code>Schema.VAT</code>.
   */
  public static final Vat VAT = Vat.VAT;
}
