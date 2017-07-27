package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.CustomerDao;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.Updater;


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
    public Customer createOrUpdateCustomer(Customer customerRequest) {

        CustomerEntity customerEntity;
        if(customerDao.exists(customerRequest.getCustomerId(), CustomerEntity.class))
        {
            CustomerEntity customerEntityFromDB = customerDao.findByCustomerName(customerRequest.getCustomerName());
            customerEntity = Updater.updateCustomerEntity(customerEntityFromDB, customerRequest);
        }
        else{
            customerEntity = CustomerDomainMapper.map(customerRequest);
        }

        return CustomerDomainMapper.map(customerDao.upsert(customerEntity));
    }

    @Override
    public Customer findByCustomerName(String customerName) {

        return CustomerDomainMapper.map(customerDao.findByCustomerName(customerName));
    }

    @Override
    public List<Customer> findAllCustomers() {

        return CustomerDomainMapper.map(customerDao.findAll());
    }
}
