package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class CustomerDomainMapper {
    public static Customer map(CustomerEntity customerEntity){
        return new Customer(customerEntity.getCustomerId(),
                                customerEntity.getCustomerName(),
                                customerEntity.getCustomerVAT(),
                                customerEntity.getCustomerRegNumber(),
                                AddressDomainMapper.map(customerEntity.getAddressEntity()),
                                DeliveryAddressDomainMapper.map(customerEntity.getDeliveryAddressEntity()));
    }
    /*

    public static CustomerEntity map(Customer customer){
        return new CustomerEntity(customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerVAT(),
                                    customer.getCustomerRegNumber(),
                                    AddressDomainMapper.map(customer.getAddress()),
                                    DeliveryAddressDomainMapper.map(customer.getDeliveryAddress()));
    }
     */

    public static CustomerEntity map(Customer customer){
        return new CustomerEntity(customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerVAT(),
                                    customer.getCustomerRegNumber());
    }

    public static List<Customer> map(List<CustomerEntity> entities){
        List<Customer> customers = new ArrayList<>();
        entities.forEach(p -> customers.add(CustomerDomainMapper.map(p)));
        return customers;
    }
}
