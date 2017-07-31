package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.*;
import com.rodion.silvermilldata.domain.*;
import com.rodion.silvermilldata.entity.*;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import com.rodion.silvermilldata.mapper.InvoiceDomainMapper;
import com.rodion.silvermilldata.mapper.OrderRowDomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class InvoiceServiceImpl implements InvoiceService {

    private static Logger LOGGER = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    private InvoiceDao invoiceDao;
    private CustomerDao customerDao;
    private DeliveryAddressDao deliveryAddressDao;
    private ProductDao productDao;
    private OrderRowDao orderRowDao;

    public InvoiceServiceImpl(InvoiceDao invoiceDao, CustomerDao customerDao, DeliveryAddressDao deliveryAddressDao, ProductDao productDao, OrderRowDao orderRowDao) {
        this.invoiceDao = invoiceDao;
        this.customerDao = customerDao;
        this.deliveryAddressDao = deliveryAddressDao;
        this.productDao = productDao;
        this.orderRowDao = orderRowDao;
    }

    @Override
    public Invoice findInvoiceByNumber(String orderNumber) {
        return InvoiceDomainMapper.map(invoiceDao.findByInvoiceNumber(orderNumber));
    }

    @Override
    public Invoice createOrUpdateInvoice(Invoice invoice) {
        /*
         OrderEntity orderEntity;
        if(exists(orderRequest)){
            orderEntity = orderDao.findByOrderNumber(orderRequest.getOrderNumber());

        }
        else{
            orderEntity = OrderDomainMapper.map(orderRequest);
        }

        setMetadata(orderEntity, orderRequest);
        orderDao.insert(orderEntity);
        return orderRequest;
         */

        InvoiceEntity invoiceEntity;
        if(exists(invoice)){
            invoiceEntity = invoiceDao.findByInvoiceNumber(invoice.getInvoiceNumber());
        }
        else{
            invoiceEntity = InvoiceDomainMapper.map(invoice);
        }

        setMetadata(invoiceEntity, invoice);
        invoiceDao.save(invoiceEntity);
        return invoice;
    }

    @Override
    public List<Invoice> findByCustomer(Customer customer) {
        return InvoiceDomainMapper.map(invoiceDao.findByCustomerEntity(CustomerDomainMapper.map(customer)));
    }

    @Override
    public List<Invoice> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate) {
        return InvoiceDomainMapper.map(invoiceDao.findByCustomerEntityAndInvoiceDateBetween(CustomerDomainMapper.map(customer), startDate, finalDate));
    }

    @Override
    public List<Invoice> findByInvoiceStatus(String invoiceStatus) {
        return InvoiceDomainMapper.map(invoiceDao.findByStatus(invoiceStatus));
    }

    private boolean exists(Invoice invoice) {

        InvoiceEntity invoiceEntity;
        try{
            invoiceEntity = invoiceDao.findByInvoiceNumber(invoice.getInvoiceNumber());

        }
        catch (Exception e){
            LOGGER.error(String.format("Invoice '%s' is not exists", invoice.getInvoiceNumber()), e);
            throw e;
        }

        return (invoiceEntity != null);
    }

    private InvoiceEntity setMetadata(InvoiceEntity entity, Invoice invoice){
        entity.setDeliveryAddressEntity(deliveryAddressDao.findByDeliveryAddressId(invoice.getDeliveryAddress().getDeliveryAddressId()));
        entity.setCustomerEntity(customerDao.findByCustomerName(invoice.getCustomer().getCustomerName()));
        //createOrderRows(invoice);
        entity.setOrderRows(OrderRowDomainMapper.mapOrderRows(createOrderRows(invoice)));
        return entity;
    }

    @Override
    public DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.save(DeliveryAddressDomainMapper.map(deliveryAddress));
        return DeliveryAddressDomainMapper.map(deliveryAddressDao.findByDeliveryAddressId(deliveryAddress.getDeliveryAddressId()));
    }

    private List<OrderRow> createOrderRows(Invoice invoice){

        invoice.getOrderRows().forEach(p -> {
            ProductEntity productEntity = productDao.findByProductArticle(p.getProduct().getProductArticle());
            OrderRowEntity orderRowEntity = OrderRowDomainMapper.map(p);
            orderRowEntity.setProduct(productEntity);
            orderRowDao.insert(orderRowEntity);
        });

        return OrderRowDomainMapper.mapOrderRowEntities(orderRowDao.findByInvoiceNumber(invoice.getInvoiceNumber()));
    }
}
