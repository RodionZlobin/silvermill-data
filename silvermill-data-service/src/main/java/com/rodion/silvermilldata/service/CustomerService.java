package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.domain.InvoiceAddress;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.InvoiceAddressEntity;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

import java.util.List;

/**
 * @author Rodion
 */
public interface CustomerService {
    Customer createOrUpdateCustomer(Customer customer);
    Customer findByCustomerName(String customerName);
    List<Customer> findAllCustomers();
    InvoiceAddressEntity upsertAddress(InvoiceAddress address);
    DeliveryAddressEntity upsertDeliveryAddress(DeliveryAddress deliveryAddress);
}
