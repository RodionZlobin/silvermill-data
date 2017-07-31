package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.InvoiceEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class InvoiceDaoImpl { //extends AbstractDao<InvoiceEntity, String> implements InvoiceDao {

    /*

    public InvoiceDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public InvoiceEntity findByInvoiceNumber(String invoiceNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("invoiceNumber").is(invoiceNumber));
        return mongoOperations.findOne(query, InvoiceEntity.class);
    }

    @Override
    public List<InvoiceEntity> findByCustomer(CustomerEntity customerEntity) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerEntity").is(customerEntity));
        return mongoOperations.find(query, InvoiceEntity.class);
    }

    @Override
    public List<InvoiceEntity> findByCustomerAtPeriod(CustomerEntity customerEntity, Date startDate, Date finalDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerEntity").is(customerEntity).and("invoiceDate").lt(finalDate).gt(startDate));
        return mongoOperations.find(query, InvoiceEntity.class);
    }

    @Override
    public List<InvoiceEntity> findByPeriod(Date startDate, Date finalDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("invoiceDate").lt(finalDate).gt(startDate));
        return mongoOperations.find(query, InvoiceEntity.class);
    }

    @Override
    public List<InvoiceEntity> findByStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("invoiceStatus").is(status));
        return mongoOperations.find(query, InvoiceEntity.class);
    }
     */
}
