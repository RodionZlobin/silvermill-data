package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface InvoiceClient {

    Invoice findInvoiceByNumber(String invoiceNumber);
    Invoice createOrUpdateInvoice(Invoice invoice);
    List<Invoice> findByCustomer(Customer customer);
    List<Invoice> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate);
    List<Invoice> findByInvoiceStatus(String invoiceStatus);
    DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress);
}
