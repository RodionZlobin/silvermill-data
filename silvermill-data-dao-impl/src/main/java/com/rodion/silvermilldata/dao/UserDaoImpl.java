package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Rodion
 */
public class UserDaoImpl extends AbstractDao<UserEntity, String> implements UserDao  {

    public UserDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public UserEntity findByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoOperations.findOne(query, UserEntity.class);
    }

    @Override
    public UserEntity findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoOperations.findOne(query, UserEntity.class);
    }


    @Override
    public boolean exists(String userId, Class<UserEntity> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoOperations.exists(query, entityClass);
    }
}
