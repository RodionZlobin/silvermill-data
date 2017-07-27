package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.CustomerDao;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;

import java.util.List;

/**
 * @author Rodion
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer createCustomer(Customer customer) {

        CustomerEntity customerEntity = CustomerDomainMapper.map(customer);
        return CustomerDomainMapper.map(customerDao.insert(customerEntity));
    }

    @Override
    public Customer findCustomerByCustomerName(String customerName) {

        return CustomerDomainMapper.map(customerDao.findCustomerByCustomerName(customerName));
    }

    @Override
    public List<Customer> findAllCustomers() {

        return CustomerDomainMapper.map(customerDao.findAll());
    }
}
