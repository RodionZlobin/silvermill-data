package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.service.CustomerService;

import java.util.List;

/**
 * @author Rodion
 */
public class CustomerClientImpl implements CustomerClient  {

    private CustomerService customerService;

    public CustomerClientImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer createOrUpdateCustomer(Customer customer) {
        return customerService.createOrUpdateCustomer(customer);
    }

    @Override
    public Customer findByCustomerName(String customerName) {
        return customerService.findByCustomerName(customerName);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }
}
