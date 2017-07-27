package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.Customer;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer findCustomerByCustomerName(String customerName);
    List<Customer> findAllCustomers();
}
