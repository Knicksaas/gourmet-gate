package org.gourmetgate.gourmetgate.data.printable;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

public class PrintableOrderPositionDo extends DoEntity {

  public DoValue<String> printableOrderPositionId() {
    return doValue("printableOrderPositionId");
  }

  public DoValue<String> printableOrderId() {
    return doValue("printableOrderId");
  }

  public DoValue<String> articleGroupId() {
    return doValue("articleGroupId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<String> optionText() {
    return doValue("optionText");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderPositionDo withPrintableOrderPositionId(String printableOrderPositionId) {
    printableOrderPositionId().set(printableOrderPositionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPrintableOrderPositionId() {
    return printableOrderPositionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderPositionDo withPrintableOrderId(String printableOrderId) {
    printableOrderId().set(printableOrderId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPrintableOrderId() {
    return printableOrderId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderPositionDo withArticleGroupId(String articleGroupId) {
    articleGroupId().set(articleGroupId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getArticleGroupId() {
    return articleGroupId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderPositionDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public PrintableOrderPositionDo withOptionText(String optionText) {
    optionText().set(optionText);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getOptionText() {
    return optionText().get();
  }
}
