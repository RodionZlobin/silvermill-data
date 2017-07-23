package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.User;

/**
 * @author Rodion
 */
public interface UserClient {
    User findUserByUserId(String userId);
    User findUserByUsername(String username);
    User createUser(User userRequest);
}
