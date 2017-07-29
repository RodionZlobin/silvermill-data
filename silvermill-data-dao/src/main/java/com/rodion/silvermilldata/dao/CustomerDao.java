package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion
 */

public interface CustomerDao extends MongoRepository<CustomerEntity, String> { //extends GenericDao<CustomerEntity, String> {
    CustomerEntity findByCustomerName(String customerName);

}
