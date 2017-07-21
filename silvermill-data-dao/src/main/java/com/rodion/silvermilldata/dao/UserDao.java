package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public interface UserDao extends MongoRepository<UserEntity, String>{
}
