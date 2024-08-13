package org.gourmetgate.gourmetgate.payment.wallee;

import org.eclipse.scout.rt.platform.config.AbstractStringConfigProperty;

public final class WalleePaymentProperties {

  private WalleePaymentProperties() {
  }

  public static class WalleeUserIdProperty extends AbstractStringConfigProperty {
    @Override
    public String getDefaultValue() {
      return null;
    }

    @Override
    public String getKey() {
      return "payment.wallee.userId";
    }

    @Override
    public String description() {
      return "The API user id of the wallee payment provider.";
    }
  }

  public static class WalleeAuthKeyProperty extends AbstractStringConfigProperty {
    @Override
    public String getDefaultValue() {
      return null;
    }

    @Override
    public String getKey() {
      return "payment.wallee.authKey";
    }

    @Override
    public String description() {
      return "The API auth key of the wallee payment provider.";
    }
  }

  public static class WalleeSpaceIdProperty extends AbstractStringConfigProperty {
    @Override
    public String getDefaultValue() {
      return null;
    }

    @Override
    public String getKey() {
      return "payment.wallee.spaceId";
    }

    @Override
    public String description() {
      return "The space id of the wallee payment provider.";
    }
  }
}
