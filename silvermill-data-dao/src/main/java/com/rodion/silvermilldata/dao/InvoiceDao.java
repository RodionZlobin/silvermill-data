package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.InvoiceEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface InvoiceDao extends GenericDao<InvoiceEntity, String> {

    InvoiceEntity findByInvoiceNumber(String invoiceNumber);
    List<InvoiceEntity> findByCustomer(CustomerEntity customerEntity);
    List<InvoiceEntity> findByCustomerAtPeriod(CustomerEntity customerEntity, Date startDate, Date finalDate);
    List<InvoiceEntity> findByPeriod(Date startDate, Date finalDate);
    List<InvoiceEntity> findByStatus(String status);

    /*
    OrderEntity findByOrderNumber(String orderNumber);
    List<OrderEntity> findByOrderDate(Date orderDate);
    List<OrderEntity> findBySpecifiedPeriod(Date dateStart, Date dateFinal);
    List<OrderEntity> findByCustomerAtPeriod(CustomerEntity customerEntity, Date dateStart, Date dateFinal);
    List<OrderEntity> findByCustomer(String customerName);
    List<OrderEntity> findByStatus(String orderStatus);
     */
}
