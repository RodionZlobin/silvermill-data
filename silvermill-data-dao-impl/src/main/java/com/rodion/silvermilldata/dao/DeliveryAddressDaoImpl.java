package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Rodion
 */
public class DeliveryAddressDaoImpl extends AbstractDao<DeliveryAddressEntity, String> implements DeliveryAddressDao {
    public DeliveryAddressDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }
}
