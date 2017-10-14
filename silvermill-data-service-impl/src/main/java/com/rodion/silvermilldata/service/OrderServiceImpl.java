package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.*;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.*;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import com.rodion.silvermilldata.mapper.OrderDomainMapper;
import com.rodion.silvermilldata.mapper.OrderRowDomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderServiceImpl implements OrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderDao orderDao;
    private DeliveryAddressDao deliveryAddressDao;
    private OrderRowDao orderRowDao;
    private CustomerDao customerDao;
    private ProductDao productDao;

    public OrderServiceImpl(OrderDao orderDao, CustomerDao customerDao, DeliveryAddressDao deliveryAddressDao, OrderRowDao orderRowDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.deliveryAddressDao = deliveryAddressDao;
        this.orderRowDao = orderRowDao;
        this.productDao = productDao;
    }

    @Override
    public Order findOrderByNumber(String orderNumber) {
        return OrderDomainMapper.map(orderDao.findByOrderNumber(orderNumber));
    }

    @Override
    public Order createOrUpdateOrder(Order orderRequest) {
        OrderEntity orderEntity;
        if(exists(orderRequest)){
            orderEntity = orderDao.findByOrderNumber(orderRequest.getOrderNumber());

        }
        else{
            orderEntity = OrderDomainMapper.map(orderRequest);
        }

        setMetadata(orderEntity, orderRequest);
        orderDao.save(orderEntity);
        return orderRequest;
    }

    @Override
    public List<Order> findByCustomer(Customer customer) {
        return OrderDomainMapper.map(orderDao.findByCustomerEntity(CustomerDomainMapper.map(customer)));
    }

    @Override
    public List<Order> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate) {
        CustomerEntity customerEntity = customerDao.findByCustomerName(customer.getCustomerName());

        return OrderDomainMapper.map(orderDao.findByCustomerEntityAndOrderDateBetween(customerEntity, startDate, finalDate));
    }

    @Override
    public List<Order> findByOrderStatus(String orderStatus) {
        return OrderDomainMapper.map(orderDao.findByStatus(orderStatus));
    }

    @Override
    public DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.save(DeliveryAddressDomainMapper.map(deliveryAddress));
        return DeliveryAddressDomainMapper.map(deliveryAddressDao.findByAddressId(deliveryAddress.getAddressId()));
    }

    @Override
    public List<OrderRow> createOrderRows(Order orderRequest){

        orderRequest.getOrderRows().forEach(p -> {
            ProductEntity productEntity = productDao.findByProductArticle(p.getProduct().getProductArticle());
            OrderRowEntity orderRowEntity = OrderRowDomainMapper.map(p);
            orderRowEntity.setProduct(productEntity);
            orderRowDao.insert(orderRowEntity);
        });

        return OrderRowDomainMapper.mapOrderRowEntities(orderRowDao.findByOrderNumber(orderRequest.getOrderNumber()));
    }

    private OrderEntity setMetadata(OrderEntity entity, Order order){
        entity.setDeliveryAddressEntity(deliveryAddressDao.findByAddressId(order.getDeliveryAddress().getAddressId()));
        entity.setCustomerEntity(customerDao.findByCustomerName(order.getCustomer().getCustomerName()));
        //createOrderRows(order);
        entity.setOrderRows(OrderRowDomainMapper.mapOrderRows(createOrderRows(order)));
        return entity;
    }

    private boolean exists(Order order) {

        OrderEntity orderEntity;
        try{
            orderEntity = orderDao.findByOrderNumber(order.getOrderNumber());

        }
        catch (Exception e){
            LOGGER.error(String.format("Order '%s' is not exists", order.getOrderNumber()), e);
            throw e;
        }

        return (orderEntity != null);
    }
}
