package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.entity.CustomerEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class CustomerDomainMapper {

    private CustomerDomainMapper(){}

    public static Customer map(CustomerEntity customerEntity){
        return customerEntity == null ? null :
                new Customer(customerEntity.getCustomerId(),
                                customerEntity.getCustomerName(),
                                customerEntity.getCustomerVAT(),
                                customerEntity.getCustomerRegNumber(),
                                InvoiceAddressDomainMapper.map(customerEntity.getInvoiceAddressEntity()),
                                DeliveryAddressDomainMapper.map(customerEntity.getDeliveryAddressEntity()));
    }
    /*

    public static CustomerEntity map(Customer customer){
        return customer = null ? null :
                    new CustomerEntity(customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerVAT(),
                                    customer.getCustomerRegNumber(),
                                    InvoiceAddressDomainMapper.map(customer.getAddress()),
                                    DeliveryAddressDomainMapper.map(customer.getDeliveryAddress()));
    }
     */

    public static CustomerEntity map(Customer customer){
        return customer == null ? null :
                new CustomerEntity(customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerVAT(),
                                    customer.getCustomerRegNumber());
    }

    public static List<Customer> map(Collection<CustomerEntity> entities){

        return entities == null ? null : entities.stream().map(CustomerDomainMapper::map).collect(Collectors.toList());
    }
}
