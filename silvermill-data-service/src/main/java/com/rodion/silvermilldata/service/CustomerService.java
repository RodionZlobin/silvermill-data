package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.Customer;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerService {
    Customer createOrUpdateCustomer(Customer customer);
    Customer findByCustomerName(String customerName);
    List<Customer> findAllCustomers();
}
