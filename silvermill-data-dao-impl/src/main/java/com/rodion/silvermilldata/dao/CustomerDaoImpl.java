package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Rodion
 */
public class CustomerDaoImpl { //extends AbstractDao<CustomerEntity, String> implements CustomerDao {
    /*

    public CustomerDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public CustomerEntity findByCustomerName(String customerName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerName").is(customerName));
        return mongoOperations.findOne(query, CustomerEntity.class);
    }

    @Override
    public boolean isExists(String customerName, Class<CustomerEntity> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerName").is(customerName));
        return mongoOperations.exists(query, entityClass);
    }
     */
}