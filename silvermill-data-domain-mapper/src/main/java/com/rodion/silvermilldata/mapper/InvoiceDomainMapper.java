package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRaw;
import com.rodion.silvermilldata.entity.InvoiceEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import com.rodion.silvermilldata.entity.OrderRawEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class InvoiceDomainMapper {
    public static Invoice map(InvoiceEntity invoiceEnity){
        return new Invoice(invoiceEnity.getInvoiceNumber(),
                            invoiceEnity.getInvoiceDate(),
                            invoiceEnity.getDueDate(),
                            CustomerDomainMapper.map(invoiceEnity.getCustomerEntity()),
                            DeliveryAddressDomainMapper.map(invoiceEnity.getDeliveryAddressEntity()),
                            invoiceEnity.getDeliveryTerms(),
                            invoiceEnity.getCountryOfOrigin(),
                            invoiceEnity.getCurrency(),
                            invoiceEnity.getVATRate(),
                            invoiceEnity.getAmount(),
                            invoiceEnity.getTotalAmount(),
                            //invoiceEnity.getOrderRaws(),
                            new ArrayList<OrderRaw>(),
                            invoiceEnity.getStatus(),
                            invoiceEnity.getTotalAmountInWords(),
                            invoiceEnity.getReducedVATNotification(),
                            //invoiceEnity.getOrders()
                            new ArrayList<Order>());
    }

    public static InvoiceEntity map(Invoice invoice){
        return new InvoiceEntity(invoice.getInvoiceNumber(),
                                    invoice.getInvoiceDate(),
                                    invoice.getDueDate(),
                                    CustomerDomainMapper.map(invoice.getCustomer()),
                                    DeliveryAddressDomainMapper.map(invoice.getDeliveryAddress()),
                                    invoice.getDeliveryTerms(),
                                    invoice.getCountryOfOrigin(),
                                    invoice.getCurrency(),
                                    invoice.getVATRate(),
                                    invoice.getAmount(),
                                    invoice.getTotalAmount(),
                                    new ArrayList<OrderRawEntity>(),
                                    invoice.getStatus(),
                                    invoice.getTotalAmountInWords(),
                                    invoice.getReducedVATNotification(),
                                    new ArrayList<OrderEntity>());
    }
}
