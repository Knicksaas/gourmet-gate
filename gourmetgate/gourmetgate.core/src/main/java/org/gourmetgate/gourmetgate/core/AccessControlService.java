package org.gourmetgate.gourmetgate.core;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.security.AbstractAccessControlService;
import org.eclipse.scout.rt.security.DefaultPermissionCollection;
import org.eclipse.scout.rt.security.IPermissionCollection;
import org.eclipse.scout.rt.security.PermissionLevel;
import org.eclipse.scout.rt.shared.session.Sessions;
import org.gourmetgate.gourmetgate.core.article.ArticleTablePagePermission;
import org.gourmetgate.gourmetgate.core.article.DeleteArticlePermission;
import org.gourmetgate.gourmetgate.core.article.ReadArticlePermission;
import org.gourmetgate.gourmetgate.core.article.UpdateArticlePermission;
import org.gourmetgate.gourmetgate.core.desktop.EscapeShopViewPermission;
import org.gourmetgate.gourmetgate.core.parameter.ReadParameterPermission;
import org.gourmetgate.gourmetgate.core.parameter.UpdateParameterPermission;
import org.gourmetgate.gourmetgate.core.table.ReadHallFormDataPermission;
import org.gourmetgate.gourmetgate.core.table.RegenerateTablesPermission;
import org.gourmetgate.gourmetgate.core.vat.ReadVatPermission;
import org.gourmetgate.gourmetgate.data.user.IUserRepository;

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
    permissions.add(new EscapeShopViewPermission(), PermissionLevel.ALL);
    permissions.add(new ArticleTablePagePermission(), PermissionLevel.ALL);
    permissions.add(new ReadArticlePermission(), PermissionLevel.ALL);
    permissions.add(new UpdateArticlePermission(), PermissionLevel.ALL);
    permissions.add(new DeleteArticlePermission(), PermissionLevel.ALL);
    permissions.add(new ReadVatPermission(), PermissionLevel.ALL);
    permissions.add(new ReadParameterPermission(), PermissionLevel.ALL);
    permissions.add(new UpdateParameterPermission(), PermissionLevel.ALL);
    permissions.add(new ReadHallFormDataPermission(), PermissionLevel.ALL);
    permissions.add(new RegenerateTablesPermission(), PermissionLevel.ALL);
  }
}
