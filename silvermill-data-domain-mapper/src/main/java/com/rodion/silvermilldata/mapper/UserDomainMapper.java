package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;

/**
 * @author Rodion
 */
public class UserDomainMapper {

    public static User map(UserEntity userEntity){
        User user = new User(userEntity.getUserId(), userEntity.getUsername(), userEntity.getPassword());
        return user;
    }

    public static UserEntity map(User user){
        UserEntity userEntity = new UserEntity(user.getUserId(), user.getUserName(), user.getPassword());
        return userEntity;
    }
}
