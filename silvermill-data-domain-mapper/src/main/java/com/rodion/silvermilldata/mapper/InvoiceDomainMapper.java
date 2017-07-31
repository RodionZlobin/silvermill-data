package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.InvoiceEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import com.rodion.silvermilldata.entity.OrderRowEntity;

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
                            OrderRowDomainMapper.mapOrderRowEntities(invoiceEnity.getOrderRows()),
                            invoiceEnity.getStatus(),
                            invoiceEnity.getTotalAmountInWords(),
                            invoiceEnity.getReducedVATNotification());
    }

    public static InvoiceEntity map(Invoice invoice){
        return new InvoiceEntity(invoice.getInvoiceNumber(),
                                    invoice.getInvoiceDate(),
                                    invoice.getDueDate(),
                                    invoice.getDeliveryTerms(),
                                    invoice.getCountryOfOrigin(),
                                    invoice.getCurrency(),
                                    invoice.getVATRate(),
                                    invoice.getAmount(),
                                    invoice.getTotalAmount(),
                                    invoice.getStatus(),
                                    invoice.getTotalAmountInWords(),
                                    invoice.getReducedVATNotification());
    }

    public static List<Invoice> map(List<InvoiceEntity> entities){
        List<Invoice> invoices = new ArrayList<>();
        entities.forEach(p -> invoices.add(InvoiceDomainMapper.map(p)));
        return invoices;
    }
}
