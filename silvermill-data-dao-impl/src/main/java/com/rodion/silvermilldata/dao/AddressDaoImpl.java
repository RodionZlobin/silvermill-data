package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.AddressEntity;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Rodion
 */
public class AddressDaoImpl extends AbstractDao<AddressEntity, String > implements AddressDao {
    public AddressDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }
}
