package org.gourmetgate.gourmetgate.data.infopage;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.InfoTileBean")
public class InfoTileBeanDo extends DoEntity {

  public DoValue<String> title() {
    return doValue("title");
  }

  public DoValue<String> description() {
    return doValue("description");
  }

  public DoValue<String> infoColorClass() {
    return doValue("infoColorClass");
  }

  public DoValue<String> iconClass() {
    return doValue("iconClass");
  }

  public DoValue<String> buttonLabel() {
    return doValue("buttonLabel");
  }

  public DoValue<String> paymentStatus() {
    return doValue("paymentStatus");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withTitle(String title) {
    title().set(title);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getTitle() {
    return title().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withDescription(String description) {
    description().set(description);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withInfoColorClass(String infoColorClass) {
    infoColorClass().set(infoColorClass);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getInfoColorClass() {
    return infoColorClass().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withIconClass(String iconClass) {
    iconClass().set(iconClass);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getIconClass() {
    return iconClass().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withButtonLabel(String buttonLabel) {
    buttonLabel().set(buttonLabel);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getButtonLabel() {
    return buttonLabel().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public InfoTileBeanDo withPaymentStatus(String paymentStatus) {
    paymentStatus().set(paymentStatus);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPaymentStatus() {
    return paymentStatus().get();
  }
}
