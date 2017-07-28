package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.OrderRowEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderRowDomainMapper {

    public static OrderRow map(OrderRowEntity entity){

        return new OrderRow(entity.getOrderRowId(),
                entity.getOrderNumber(),
                ProductDomainMapper.map(entity.getProduct()),
                entity.getUnit(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getAmount());
    }

    public static OrderRowEntity map(OrderRow orderRow){

        return new OrderRowEntity(orderRow.getOrderRowId(),
                                    orderRow.getOrderNumber(),
                                    ProductDomainMapper.map(orderRow.getProduct()),
                                    orderRow.getUnit(),
                                    orderRow.getQuantity(),
                                    orderRow.getPrice(),
                                    orderRow.getAmount());
    }

    public static List<OrderRowEntity> mapOrderRaws(List<OrderRow> orderRows){
        List<OrderRowEntity> entities = new ArrayList<>();
        orderRows.forEach(p -> entities.add(OrderRowDomainMapper.map(p)));
        return entities;
    }

    public static List<OrderRow> mapOrderRawEntities(List<OrderRowEntity> entities){
        List<OrderRow> orderRows = new ArrayList<>();
        entities.forEach(p -> orderRows.add(OrderRowDomainMapper.map(p)));
        return orderRows;
    }

}
