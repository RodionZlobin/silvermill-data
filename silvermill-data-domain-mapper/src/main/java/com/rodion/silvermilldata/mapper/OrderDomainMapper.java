package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderDomainMapper {

    public static Order map(OrderEntity entity){
        return new Order(entity.getOrderNumber(),
                            entity.getOrderDate(),
                            entity.getPaymentTerms(),
                            CustomerDomainMapper.map(entity.getCustomerEntity()),
                            DeliveryAddressDomainMapper.map(entity.getDeliveryAddressEntity()),
                            entity.getDeliveryTerms(),
                            //entity.getOrderRows(),
                            new ArrayList<OrderRow>(),
                            entity.getCurrency(),
                            entity.getVATRate(),
                            entity.getAmount(),
                            entity.getTotalAmount(),
                            entity.getStatus());
    }

    public static OrderEntity map(Order order){
        return new OrderEntity(order.getOrderNumber(),
                                order.getOrderDate(),
                                order.getPaymentTerms(),
                                order.getDeliveryTerms(),
                                order.getCurrency(),
                                order.getVATRate(),
                                order.getAmount(),
                                order.getTotalAmount(),
                                order.getStatus()
                                );
    }

    public static List<Order> map(List<OrderEntity> entities){
        List<Order> orders = new ArrayList<>();
        entities.forEach(p -> orders.add(OrderDomainMapper.map(p)));
        return orders;
    }
}
