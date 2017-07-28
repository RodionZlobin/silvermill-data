package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.AddressEntity;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerService {
    Customer createOrUpdateCustomer(Customer customer);
    Customer findByCustomerName(String customerName);
    List<Customer> findAllCustomers();
    AddressEntity upsertAddress(Address address);
    DeliveryAddressEntity upsertDeliveryAddress(DeliveryAddress deliveryAddress);
}
