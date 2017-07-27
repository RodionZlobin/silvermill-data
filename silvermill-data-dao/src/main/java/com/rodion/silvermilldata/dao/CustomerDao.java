package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;

/**
 * @author Rodion
 */
public interface CustomerDao extends GenericDao<CustomerEntity, String> {
    CustomerEntity findByCustomerName(String customerName);

}
