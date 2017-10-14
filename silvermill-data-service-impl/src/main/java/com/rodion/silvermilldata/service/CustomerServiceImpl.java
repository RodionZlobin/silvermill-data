package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.InvoiceAddressDao;
import com.rodion.silvermilldata.dao.CustomerDao;
import com.rodion.silvermilldata.dao.DeliveryAddressDao;
import com.rodion.silvermilldata.domain.InvoiceAddress;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.InvoiceAddressEntity;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.mapper.InvoiceAddressDomainMapper;
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
    private InvoiceAddressDao invoiceAddressDao;
    private DeliveryAddressDao deliveryAddressDao;

    public CustomerServiceImpl(CustomerDao customerDao, InvoiceAddressDao invoiceAddressDao, DeliveryAddressDao deliveryAddressDao) {
        this.customerDao = customerDao;
        this.invoiceAddressDao = invoiceAddressDao;
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
        //customerEntity.setInvoiceAddressEntity(upsertAddress(customerRequest.getAddress()));
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
    public InvoiceAddressEntity upsertAddress(InvoiceAddress address){
        invoiceAddressDao.save(InvoiceAddressDomainMapper.map(address));
        return invoiceAddressDao.findByAddressId(address.getAddressId());
    }

    @Override
    public DeliveryAddressEntity upsertDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.save(DeliveryAddressDomainMapper.map(deliveryAddress));
        return deliveryAddressDao.findByAddressId(deliveryAddress.getAddressId());
    }

    private CustomerEntity setAddresses(CustomerEntity entity, Customer customer){
        entity.setInvoiceAddressEntity(upsertAddress(customer.getAddress()));
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
