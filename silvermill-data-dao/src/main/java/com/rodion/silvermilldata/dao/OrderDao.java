package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface OrderDao extends GenericDao<OrderEntity, String> {
    OrderEntity findByOrderNumber(String orderNumber);
    List<OrderEntity> findByOrderDate(Date orderDate);
    List<OrderEntity> findBySpecifiedPeriod(Date dateStart, Date dateFinal);
    List<OrderEntity> findByCustomerAtPeriod(CustomerEntity customerEntity, Date dateStart, Date dateFinal);

    //List<OrderEntity> findByOrderDateBetween(dateStart, dateFinal); - extends MongoRepository, Spring AutoGen queries...
}
