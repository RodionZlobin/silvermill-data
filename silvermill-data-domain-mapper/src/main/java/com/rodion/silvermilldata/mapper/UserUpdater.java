package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;

/**
 * @author Rodion
 */
public class UserUpdater {
    public static UserEntity update(UserEntity entity, User user){
        entity.setUserId(user.getUserId());
        entity.setUsername(user.getUserName());
        entity.setPassword(user.getPassword());
        return entity;
    }
}
