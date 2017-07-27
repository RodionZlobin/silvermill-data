package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerClient {
    Customer createCustomer(Customer customer);
    Customer findCustomerByCustomerName(String customerName);
    List<Customer> findAllCustomers();
}
