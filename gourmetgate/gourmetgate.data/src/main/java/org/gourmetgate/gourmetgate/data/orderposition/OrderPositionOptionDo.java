package org.gourmetgate.gourmetgate.data.orderposition;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.OrderPositionOption")
public class OrderPositionOptionDo extends DoEntity {

  public DoValue<String> orderPositionOptionId() {
    return doValue("orderPositionOptionId");
  }

  public DoValue<String> orderPositionId() {
    return doValue("orderPositionId");
  }

  public DoValue<String> articleOptionId() {
    return doValue("articleOptionId");
  }

  /**
   * No actual column in the database but nescessary for transfering it to the UI
   */
  public DoValue<String> description() {
    return doValue("description");
  }

  public DoValue<Boolean> selected() {
    return doValue("selected");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionOptionDo withOrderPositionOptionId(String orderPositionOptionId) {
    orderPositionOptionId().set(orderPositionOptionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderPositionOptionId() {
    return orderPositionOptionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionOptionDo withOrderPositionId(String orderPositionId) {
    orderPositionId().set(orderPositionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOrderPositionId() {
    return orderPositionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionOptionDo withArticleOptionId(String articleOptionId) {
    articleOptionId().set(articleOptionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleOptionId() {
    return articleOptionId().get();
  }

  /**
   * See {@link #description()}.
   */
  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionOptionDo withDescription(String description) {
    description().set(description);
    return this;
  }

  /**
   * See {@link #description()}.
   */
  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public OrderPositionOptionDo withSelected(Boolean selected) {
    selected().set(selected);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getSelected() {
    return selected().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isSelected() {
    return nvl(getSelected());
  }
}
