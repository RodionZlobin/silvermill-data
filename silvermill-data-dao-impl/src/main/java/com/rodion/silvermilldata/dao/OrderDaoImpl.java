package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.OrderEntity;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Rodion
 */
public class OrderDaoImpl extends AbstractDao<OrderEntity, String> implements OrderDao {
    public OrderDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }
}
