package org.gourmetgate.gourmetgate.core;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.security.*;
import org.eclipse.scout.rt.shared.session.Sessions;
import org.gourmetgate.gourmetgate.core.article.ArticleTablePagePermission;
import org.gourmetgate.gourmetgate.data.user.IUserRepository;

import java.util.stream.Collectors;

public class AccessControlService extends AbstractAccessControlService<String> {

  @Override
  protected String getCurrentUserCacheKey() {
    return Sessions.getCurrentUserId();
  }

  @Override
  protected IPermissionCollection execLoadPermissions(String userId) {
    IPermissionCollection permissions = BEANS.get(DefaultPermissionCollection.class);
    if (isAdmin(userId)) {
      addAllAdminPermissions(permissions);
    }
    permissions.setReadOnly();
    return permissions;
  }

  protected boolean isAdmin(String userId) {
    return BEANS.get(IUserRepository.class).isAdmin(userId);
  }

  protected void addAllAdminPermissions(IPermissionCollection permissions) {
    permissions.add(new ArticleTablePagePermission(), PermissionLevel.ALL);
  }
}
