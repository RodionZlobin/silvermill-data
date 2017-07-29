package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.AddressEntity;
import com.rodion.silvermilldata.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion
 */
public interface AddressDao extends MongoRepository<AddressEntity, String>{ //extends GenericDao<AddressEntity, String> {
    AddressEntity findByAddressId(String addressId);
}
