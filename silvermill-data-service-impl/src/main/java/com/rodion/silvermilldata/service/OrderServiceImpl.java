package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.*;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import com.rodion.silvermilldata.entity.OrderRowEntity;
import com.rodion.silvermilldata.entity.ProductEntity;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import com.rodion.silvermilldata.mapper.OrderDomainMapper;
import com.rodion.silvermilldata.mapper.OrderRowDomainMapper;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderServiceImpl implements OrderService {

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
        if(orderDao.isExists(orderRequest.getOrderNumber(), OrderEntity.class)){
            orderEntity = orderDao.findByOrderNumber(orderRequest.getOrderNumber());

        }
        else{
            orderEntity = OrderDomainMapper.map(orderRequest);
        }

        setMetadata(orderEntity, orderRequest);
        orderDao.insert(orderEntity);
        return orderRequest;
    }

    @Override
    public List<Order> findByCustomer(Customer customer) {
        return OrderDomainMapper.map(orderDao.findByCustomer(customer.getCustomerName()));
    }

    @Override
    public List<Order> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate) {
        return OrderDomainMapper.map(orderDao.findByCustomerAtPeriod(CustomerDomainMapper.map(customer), startDate, finalDate));
    }

    @Override
    public List<Order> findByOrderStatus(String orderStatus) {
        return OrderDomainMapper.map(orderDao.findByStatus(orderStatus));
    }

    @Override
    public DeliveryAddressEntity upsertDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.upsert(DeliveryAddressDomainMapper.map(deliveryAddress));
        return deliveryAddressDao.findByDeliveryAddressId(deliveryAddress.getDeliveryAddressId());
    }

    @Override
    public void createOrderRows(Order orderRequest){

        orderRequest.getOrderRows().forEach(p -> {
            ProductEntity productEntity = productDao.findByProductArticle(p.getProduct().getProductArticle());
            OrderRowEntity orderRowEntity = OrderRowDomainMapper.map(p);
            orderRowEntity.setProduct(productEntity);
            orderRowDao.insert(orderRowEntity);
        });
    }

    private OrderEntity setMetadata(OrderEntity entity, Order order){
        entity.setDeliveryAddressEntity(deliveryAddressDao.findByDeliveryAddressId(order.getDeliveryAddress().getDeliveryAddressId()));
        entity.setCustomerEntity(customerDao.findByCustomerName(order.getCustomer().getCustomerName()));
        createOrderRows(order);
        entity.setOrderRows(orderRowDao.findByOrderNumber(order.getOrderNumber()));
        return entity;
    }
}
