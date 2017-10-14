package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion
 */
public interface DeliveryAddressDao extends MongoRepository<DeliveryAddressEntity, String>{//extends GenericDao<DeliveryAddressEntity, String>{
    DeliveryAddressEntity findByAddressId(String deliveryAddressId);
}
