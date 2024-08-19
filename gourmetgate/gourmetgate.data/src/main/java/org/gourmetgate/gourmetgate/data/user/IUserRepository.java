package org.gourmetgate.gourmetgate.data.user;

import org.gourmetgate.gourmetgate.data.common.ICrudRepository;

import java.util.Optional;

public interface IUserRepository extends ICrudRepository<UserDo> {

  Optional<UserDo> findByUsername(String username);

  boolean isAdmin(String userName);
}
