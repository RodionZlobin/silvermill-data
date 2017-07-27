package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Rodion
 */
public class DeliveryAddressDaoImpl extends AbstractDao<DeliveryAddressEntity, String> implements DeliveryAddressDao {
    public DeliveryAddressDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public DeliveryAddressEntity findByDeliveryAddressId(String deliveryAddressId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("deliveryAddressId").is(deliveryAddressId));
        return mongoOperations.findOne(query, DeliveryAddressEntity.class);
    }
}
