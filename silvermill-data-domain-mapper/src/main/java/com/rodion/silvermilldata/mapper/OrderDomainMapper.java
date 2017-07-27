package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.domain.OrderRaw;
import com.rodion.silvermilldata.entity.OrderEntity;
import com.rodion.silvermilldata.entity.OrderRawEntity;

import java.util.ArrayList;

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
                            //entity.getOrderRaws(),
                            new ArrayList<OrderRaw>(),
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
                                CustomerDomainMapper.map(order.getCustomer()),
                                DeliveryAddressDomainMapper.map(order.getDeliveryAddress()),
                                order.getDeliveryTerms(),
                                new ArrayList<OrderRawEntity>(),
                                order.getCurrency(),
                                order.getVATRate(),
                                order.getAmount(),
                                order.getTotalAmount(),
                                order.getStatus()
                                );
    }
}
