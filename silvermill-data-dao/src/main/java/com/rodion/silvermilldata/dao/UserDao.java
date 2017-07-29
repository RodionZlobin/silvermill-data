package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion
 */
public interface UserDao extends MongoRepository<UserEntity, String>{ //extends GenericDao<UserEntity, String>{

    UserEntity findByUserId(String userId);
    UserEntity findByUsername(String username);
}
