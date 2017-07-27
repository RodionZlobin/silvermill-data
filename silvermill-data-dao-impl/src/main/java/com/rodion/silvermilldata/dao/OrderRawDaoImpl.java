package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.OrderRawEntity;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Rodion
 */
public class OrderRawDaoImpl extends AbstractDao<OrderRawEntity, String> implements OrderRawDao {
    public OrderRawDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }
}
