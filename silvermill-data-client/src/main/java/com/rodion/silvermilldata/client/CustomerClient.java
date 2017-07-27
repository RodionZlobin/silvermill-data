package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerClient {
    Customer createOrUpdateCustomer(Customer customer);
    Customer findByCustomerName(String customerName);
    List<Customer> findAllCustomers();
}
