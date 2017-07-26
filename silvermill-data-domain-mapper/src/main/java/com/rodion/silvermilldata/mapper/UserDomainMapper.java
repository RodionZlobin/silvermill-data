package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

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

    public static List<User> map(List<UserEntity> userEntities){
        List<User> users = new ArrayList<>();
        userEntities.forEach(p -> users.add(UserDomainMapper.map(p)));
        return users;
    }
}
