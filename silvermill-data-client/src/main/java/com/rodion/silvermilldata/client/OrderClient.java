package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public interface OrderClient {
    Order findOrderByNumber(String orderNumber);
    Order createOrUpdateOrder(Order order);
    List<Order> findByCustomer(Customer customer);
    List<Order> findByCustomerAtPeriod(Customer customer, Date startDate, Date finalDate);
    List<Order> findByOrderStatus(String orderStatus);

    DeliveryAddress upsertDeliveryAddress(DeliveryAddress deliveryAddress);
    List<OrderRow> createOrderRows(Order order);
}
