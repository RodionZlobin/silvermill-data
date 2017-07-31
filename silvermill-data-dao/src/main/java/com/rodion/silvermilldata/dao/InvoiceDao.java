package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.InvoiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface InvoiceDao extends MongoRepository<InvoiceEntity, String>{//extends GenericDao<InvoiceEntity, String> {

    InvoiceEntity findByInvoiceNumber(String invoiceNumber);
    List<InvoiceEntity> findByCustomerEntity(CustomerEntity customerEntity);
    List<InvoiceEntity> findByCustomerEntityAndInvoiceDateBetween(CustomerEntity customerEntity, Date startDate, Date finalDate);
    List<InvoiceEntity> findByInvoiceDateBetween(Date startDate, Date finalDate);
    List<InvoiceEntity> findByStatus(String status);

}
