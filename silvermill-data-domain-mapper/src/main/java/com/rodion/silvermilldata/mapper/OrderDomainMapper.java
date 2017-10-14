package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermilldata.entity.OrderEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class OrderDomainMapper {

    private OrderDomainMapper(){}

    public static Order map(OrderEntity entity){
        return entity == null ? null :
                new Order(entity.getOrderNumber(),
                            entity.getOrderDate(),
                            entity.getPaymentTerms(),
                            CustomerDomainMapper.map(entity.getCustomerEntity()),
                            DeliveryAddressDomainMapper.map(entity.getDeliveryAddressEntity()),
                            entity.getDeliveryTerms(),
                            OrderRowDomainMapper.mapOrderRowEntities(entity.getOrderRows()),
                            entity.getCurrency(),
                            entity.getVATRate(),
                            entity.getAmount(),
                            entity.getTotalAmount(),
                            entity.getStatus());
    }

    public static OrderEntity map(Order order){
        return order == null ? null :
                new OrderEntity(order.getOrderNumber(),
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

    public static List<Order> map(Collection<OrderEntity> entities){

        return entities == null ? null : entities.stream().map(OrderDomainMapper::map).collect(Collectors.toList());
    }
}
