package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermilldata.entity.InvoiceEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class InvoiceDomainMapper {

    private InvoiceDomainMapper(){}

    public static Invoice map(InvoiceEntity invoiceEnity){
        return invoiceEnity == null ? null :
                new Invoice(invoiceEnity.getInvoiceNumber(),
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
        return invoice == null ? null :
                new InvoiceEntity(invoice.getInvoiceNumber(),
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

    public static List<Invoice> map(Collection<InvoiceEntity> entities){

        return entities == null ? null : entities.stream().map(InvoiceDomainMapper::map).collect(Collectors.toList());
    }

}
