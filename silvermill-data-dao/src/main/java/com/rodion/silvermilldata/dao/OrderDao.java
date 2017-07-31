package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface OrderDao extends MongoRepository<OrderEntity, String>{//extends GenericDao<OrderEntity, String> {
    OrderEntity findByOrderNumber(String orderNumber);
    List<OrderEntity> findByOrderDate(Date orderDate);
    List<OrderEntity> findByOrderDateBetween(Date dateStart, Date dateFinal);
    List<OrderEntity> findByCustomerEntityAndOrderDateBetween(CustomerEntity customerEntity, Date dateStart, Date dateFinal);
    List<OrderEntity> findByCustomerEntity(CustomerEntity customerEntity);
    List<OrderEntity> findByStatus(String orderStatus);
}
