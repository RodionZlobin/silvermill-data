package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class UserDomainMapper {

    private UserDomainMapper(){}

    public static User map(UserEntity userEntity){
        return userEntity == null ? null :
                new User(userEntity.getUserId(),
                        userEntity.getUsername(),
                        userEntity.getPassword());
    }

    public static UserEntity map(User user){
        return user == null ? null :
                new UserEntity(user.getUserId(),
                                user.getUserName(),
                                user.getPassword());
    }

    public static List<User> map(Collection<UserEntity> userEntities){

        return userEntities == null ? null : userEntities.stream().map(UserDomainMapper::map).collect(Collectors.toList());
    }
}
