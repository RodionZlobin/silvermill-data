package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.User;

import java.util.List;

/**
 * @author Rodion
 */
public interface UserService {
    User findUserByUserId(String id);
    User findUserByUsername(String username);
    User createOrUpdateUser(User user);
    List<User> findAllUsers();
}
