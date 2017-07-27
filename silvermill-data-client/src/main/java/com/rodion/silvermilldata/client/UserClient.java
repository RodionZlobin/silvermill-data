package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.User;

import java.util.List;

/**
 * @author Rodion
 */
public interface UserClient {
    User findUserByUserId(String userId);
    User findUserByUsername(String username);
    User createOrUpdateUser(User userRequest);
    List<User> getAllUsers();
}
