package org.gourmetgate.gourmetgate.data.user;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

public class UserDo extends DoEntity {

  public DoValue<String> userId() {
    return doValue("userId");
  }

  public DoValue<String> userName() {
    return doValue("userName");
  }

  public DoValue<String> passwordHash() {
    return doValue("passwordHash");
  }

  public DoValue<String> salt() {
    return doValue("salt");
  }

  public DoValue<Boolean> admin() {
    return doValue("admin");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public UserDo withUserId(String userId) {
    userId().set(userId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getUserId() {
    return userId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UserDo withUserName(String userName) {
    userName().set(userName);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getUserName() {
    return userName().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UserDo withPasswordHash(String passwordHash) {
    passwordHash().set(passwordHash);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getPasswordHash() {
    return passwordHash().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UserDo withSalt(String salt) {
    salt().set(salt);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getSalt() {
    return salt().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UserDo withAdmin(Boolean admin) {
    admin().set(admin);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getAdmin() {
    return admin().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isAdmin() {
    return nvl(getAdmin());
  }
}
