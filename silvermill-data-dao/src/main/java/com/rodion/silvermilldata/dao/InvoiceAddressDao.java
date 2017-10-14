package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.InvoiceAddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rodion
 */
public interface InvoiceAddressDao extends MongoRepository<InvoiceAddressEntity, String>{ //extends GenericDao<InvoiceAddressEntity, String> {
    InvoiceAddressEntity findByAddressId(String addressId);
}
