package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.OrderRowEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Rodion
 */
public interface OrderRowDao extends MongoRepository<OrderRowEntity, String>{ //extends GenericDao<OrderRowEntity, String> {
    List<OrderRowEntity> findByOrderNumber(String orderNumber);
    List<OrderRowEntity> findByInvoiceNumber(String invoiceNumber);
}
