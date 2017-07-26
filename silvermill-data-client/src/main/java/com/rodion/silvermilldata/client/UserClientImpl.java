package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.service.UserService;

import java.util.List;

/**
 * @author Rodion
 */
public class UserClientImpl implements UserClient {

    private UserService userService;

    public UserClientImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findUserByUserId(String userId) {

        return userService.findUserByUserId(userId);
    }

    @Override
    public User findUserByUsername(String username) {

        return userService.findUserByUsername(username);
    }

    @Override
    public User createUser(User userRequest) {
        
        return userService.createUser(userRequest);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
