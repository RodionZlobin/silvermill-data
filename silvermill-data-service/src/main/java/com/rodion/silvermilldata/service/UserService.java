package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;

/**
 * @author Rodion
 */
public interface UserService {
    User findUserByUserId(String id);
    User findUserByUsername(String username);
    User createUser(User user);
}
