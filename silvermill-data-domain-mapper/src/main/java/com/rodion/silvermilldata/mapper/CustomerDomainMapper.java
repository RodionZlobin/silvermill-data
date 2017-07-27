package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.entity.CustomerEntity;

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

    public static CustomerEntity map(Customer customer){
        return new CustomerEntity(customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerVAT(),
                                    customer.getCustomerRegNumber(),
                                    AddressDomainMapper.map(customer.getAddress()),
                                    DeliveryAddressDomainMapper.map(customer.getDeliveryAddress()));
    }
}
