package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderClientImpl implements OrderClient {

    private OrderService orderService;

    public OrderClientImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order findOrderByNumber(String orderNumber) {
        return orderService.findOrderByNumber(orderNumber);
    }

    @Override
    public Order createOrUpdateOrder(Order order) {
        return orderService.createOrUpdateOrder(order);
    }

    @Override
    public List<Order> findByCustomer(Customer customer) {
        return orderService.findByCustomer(customer);
    }

    @Override
    public List<Order> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate) {
        return orderService.findByCustomerAtPeriod(customer, startDate, finalDate);
    }

    @Override
    public List<Order> findByOrderStatus(String orderStatus) {
        return orderService.findByOrderStatus(orderStatus);
    }

    @Override
    public DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress) {
        return orderService.upsertDeliveryAddress(deliveryAddress);
    }

    @Override
    public List<OrderRow> createOrderRows(Order order) {
        return orderService.createOrderRows(order);
    }
}
