package org.gourmetgate.gourmetgate.data.payment;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.Redirect")
public class RedirectDo extends DoEntity {

  public DoValue<String> redirectUrl() {
    return doValue("redirectUrl");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public RedirectDo withRedirectUrl(String redirectUrl) {
    redirectUrl().set(redirectUrl);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getRedirectUrl() {
    return redirectUrl().get();
  }
}
