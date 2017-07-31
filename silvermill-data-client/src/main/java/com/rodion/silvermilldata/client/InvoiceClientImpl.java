package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.service.InvoiceService;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class InvoiceClientImpl implements InvoiceClient {

    private InvoiceService invoiceService;

    public InvoiceClientImpl(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public Invoice findInvoiceByNumber(String invoiceNumber) {
        return invoiceService.findInvoiceByNumber(invoiceNumber);
    }

    @Override
    public Invoice createOrUpdateInvoice(Invoice invoice) {
        return invoiceService.createOrUpdateInvoice(invoice);
    }

    @Override
    public List<Invoice> findByCustomer(Customer customer) {
        return invoiceService.findByCustomer(customer);
    }

    @Override
    public List<Invoice> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate) {
        return invoiceService.findByCustomerAtPeriod(customer, startDate, finalDate);
    }

    @Override
    public List<Invoice> findByInvoiceStatus(String invoiceStatus) {
        return invoiceService.findByInvoiceStatus(invoiceStatus);
    }

    @Override
    public DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress) {
        return invoiceService.upsertDeliveryAddress(deliveryAddress);
    }
}
