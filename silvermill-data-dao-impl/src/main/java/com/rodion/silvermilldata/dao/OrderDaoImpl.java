package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderDaoImpl extends AbstractDao<OrderEntity, String> implements OrderDao {
    public OrderDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public OrderEntity findByOrderNumber(String orderNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderNumber").is(orderNumber));
        return mongoOperations.findOne(query, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findByOrderDate(Date orderDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderDate").is(orderDate));
        return mongoOperations.find(query, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findBySpecifiedPeriod(Date dateStart, Date dateFinal) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderDate").lt(dateFinal).gt(dateStart));
        return mongoOperations.find(query, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findByCustomerAtPeriod(CustomerEntity customerEntity, Date dateStart, Date dateFinal) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerName").is(customerEntity.getCustomerName()).and("orderDate").lt(dateFinal).gt(dateStart));
        return mongoOperations.find(query, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findByCustomer(String customerName) {
        return null;
    }

    @Override
    public List<OrderEntity> findByStatus(String orderStatus) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderStatus").is(orderStatus));
        return mongoOperations.find(query, OrderEntity.class);
    }

    @Override
    public boolean isExists(String orderNumber, Class<OrderEntity> entityClass){
        Query query = new Query();
        query.addCriteria(Criteria.where("userNumber").is(orderNumber));
        return mongoOperations.exists(query, entityClass);
    }
}
