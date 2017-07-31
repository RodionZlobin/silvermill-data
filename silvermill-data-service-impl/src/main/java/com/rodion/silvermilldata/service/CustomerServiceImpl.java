package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.AddressDao;
import com.rodion.silvermilldata.dao.CustomerDao;
import com.rodion.silvermilldata.dao.DeliveryAddressDao;
import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.AddressEntity;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.mapper.AddressDomainMapper;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 * @author Rodion
 */
public class CustomerServiceImpl implements CustomerService {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);


    private CustomerDao customerDao;
    private AddressDao addressDao;
    private DeliveryAddressDao deliveryAddressDao;

    public CustomerServiceImpl(CustomerDao customerDao, AddressDao addressDao, DeliveryAddressDao deliveryAddressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
        this.deliveryAddressDao = deliveryAddressDao;
    }

    @Override
    public Customer createOrUpdateCustomer(Customer customerRequest) {

        CustomerEntity customerEntity;
        if(exists(customerRequest))
        {
            //CustomerEntity customerEntityFromDB = customerDao.findByCustomerName(customerRequest.getCustomerName());
            //customerEntity = Updater.updateCustomerEntity(customerEntityFromDB, customerRequest);
            customerEntity = customerDao.findByCustomerName(customerRequest.getCustomerName());
        }
        else{
            customerEntity = CustomerDomainMapper.map(customerRequest);
        }
        //customerEntity.setAddressEntity(upsertAddress(customerRequest.getAddress()));
        //customerEntity.setDeliveryAddressEntity(upsertDeliveryAddress(customerRequest.getDeliveryAddress()));

        setAddresses(customerEntity, customerRequest);

        return CustomerDomainMapper.map(customerDao.save(customerEntity));
    }

    @Override
    public Customer findByCustomerName(String customerName) {

        return CustomerDomainMapper.map(customerDao.findByCustomerName(customerName));
    }

    @Override
    public List<Customer> findAllCustomers() {

        return CustomerDomainMapper.map(customerDao.findAll());
    }

    @Override
    public AddressEntity upsertAddress(Address address){
        addressDao.save(AddressDomainMapper.map(address));
        return addressDao.findByAddressId(address.getAddressId());
    }

    @Override
    public DeliveryAddressEntity upsertDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.save(DeliveryAddressDomainMapper.map(deliveryAddress));
        return deliveryAddressDao.findByDeliveryAddressId(deliveryAddress.getDeliveryAddressId());
    }

    private CustomerEntity setAddresses(CustomerEntity entity, Customer customer){
        entity.setAddressEntity(upsertAddress(customer.getAddress()));
        entity.setDeliveryAddressEntity(upsertDeliveryAddress(customer.getDeliveryAddress()));

        return entity;
    }

    private boolean exists(Customer customerRequest) {

        CustomerEntity customerEntity;
        try{
            customerEntity = customerDao.findByCustomerName(customerRequest.getCustomerName());

        }
        catch (Exception e){
            LOGGER.error(String.format("Customer '%s' is not exists", customerRequest.getCustomerName()), e);
            throw e;
        }

        return (customerEntity != null);
    }
}
