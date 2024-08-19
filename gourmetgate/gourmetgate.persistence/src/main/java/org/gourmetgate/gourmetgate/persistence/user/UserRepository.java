package org.gourmetgate.gourmetgate.persistence.user;

import org.gourmetgate.gourmetgate.data.user.IUserRepository;
import org.gourmetgate.gourmetgate.data.user.UserDo;
import org.gourmetgate.gourmetgate.persistence.common.AbstractRepository;
import org.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import org.gourmetgate.gourmetgate.persistence.tables.User;
import org.gourmetgate.gourmetgate.persistence.tables.records.UserRecord;
import org.jooq.Field;

import java.util.Optional;

import static org.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class UserRepository extends AbstractRepository<User, UserRecord, UserDo> implements IUserRepository {

  @Override
  public User getTable() {
    return User.USER;
  }

  @Override
  public Field<String> getIdColumn() {
    return getTable().USER_ID;
  }

  @Override
  public Optional<UserDo> findByUsername(String username) {
    return Optional.ofNullable(
        jooq()
          .selectFrom(getTable())
          .where(getTable().USER_NAME.eq(username))
          .fetchOne())
      .map(this::fromRecordToDo);
  }

  @Override
  public boolean isAdmin(String userName) {
    return findByUsername(userName)
      .map(UserDo::isAdmin)
      .orElse(false);
  }

  @Override
  protected DoEntityBeanMappings<UserDo, UserRecord> mappings() {
    return new DoEntityBeanMappings<UserDo, UserRecord>()
      .with(UserDo::userId, UserRecord::getUserId, UserRecord::setUserId)
      .with(UserDo::userName, UserRecord::getUserName, UserRecord::setUserName)
      .with(UserDo::passwordHash, UserRecord::getPasswordHas, UserRecord::setPasswordHas)
      .with(UserDo::salt, UserRecord::getSalt, UserRecord::setSalt)
      .with(UserDo::admin, UserRecord::getAdmin, UserRecord::setAdmin);
  }
}
