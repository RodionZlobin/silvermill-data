package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.OrderRowEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author Rodion
 */
public class OrderRowDaoImpl extends AbstractDao<OrderRowEntity, String> implements OrderRowDao {
    public OrderRowDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public List<OrderRowEntity> findByOrderNumber(String orderNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderNumber").is(orderNumber));
        return mongoOperations.find(query, OrderRowEntity.class);
    }
}
