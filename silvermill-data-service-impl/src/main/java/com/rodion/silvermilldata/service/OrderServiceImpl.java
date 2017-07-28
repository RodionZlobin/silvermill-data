package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.AddressDao;
import com.rodion.silvermilldata.dao.DeliveryAddressDao;
import com.rodion.silvermilldata.dao.OrderDao;
import com.rodion.silvermilldata.dao.OrderRowDao;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.entity.OrderEntity;
import com.rodion.silvermilldata.entity.OrderRowEntity;
import com.rodion.silvermilldata.mapper.*;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private AddressDao addressDao;
    private DeliveryAddressDao deliveryAddressDao;
    private OrderRowDao orderRowDao;

    public OrderServiceImpl(OrderDao orderDao, AddressDao addressDao, DeliveryAddressDao deliveryAddressDao, OrderRowDao orderRowDao) {
        this.orderDao = orderDao;
        this.addressDao = addressDao;
        this.deliveryAddressDao = deliveryAddressDao;
        this.orderRowDao = orderRowDao;
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

        return null;
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
        orderRowDao.insertAll(OrderRowDomainMapper.mapOrderRaws(orderRequest.getOrderRows()), OrderRowEntity.class);
    }


    private OrderEntity setMetadata(OrderEntity entity, Order order){
        entity.setDeliveryAddressEntity(upsertDeliveryAddress(order.getDeliveryAddress()));
        entity.setOrderRaws(orderRowDao.findByOrderNumber(order.getOrderNumber()));
        return entity;
    }
}
