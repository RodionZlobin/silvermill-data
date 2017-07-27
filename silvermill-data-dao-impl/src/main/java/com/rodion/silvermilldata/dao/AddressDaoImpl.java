package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.AddressEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Rodion
 */
public class AddressDaoImpl extends AbstractDao<AddressEntity, String > implements AddressDao {
    public AddressDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public AddressEntity findByAddressID(String addressId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("addressId").is(addressId));
        return mongoOperations.findOne(query, AddressEntity.class);
    }
}
