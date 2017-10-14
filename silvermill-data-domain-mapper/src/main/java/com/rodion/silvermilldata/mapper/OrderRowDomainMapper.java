package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.entity.OrderRowEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class OrderRowDomainMapper {

    private OrderRowDomainMapper() {
    }

    public static OrderRow map(OrderRowEntity entity){

        return entity == null ? null :
                new OrderRow(entity.getOrderRowId(),
                                entity.getOrderNumber(),
                                entity.getInvoiceNumber(),
                                ProductDomainMapper.map(entity.getProduct()),
                                entity.getUnit(),
                                entity.getQuantity(),
                                entity.getPrice(),
                                entity.getAmount());
    }

    public static OrderRowEntity map(OrderRow orderRow){

        return orderRow == null ? null :
                new OrderRowEntity(orderRow.getOrderRowId(),
                                    orderRow.getOrderNumber(),
                                    orderRow.getInvoiceNumber(),
                                    ProductDomainMapper.map(orderRow.getProduct()),
                                    orderRow.getUnit(),
                                    orderRow.getQuantity(),
                                    orderRow.getPrice(),
                                    orderRow.getAmount());
    }

    public static List<OrderRowEntity> mapOrderRows(Collection<OrderRow> orderRows){

        return orderRows == null ? null : orderRows.stream().map(OrderRowDomainMapper::map).collect(Collectors.toList());
    }

    public static List<OrderRow> mapOrderRowEntities(Collection<OrderRowEntity> entities){

        return entities == null ? null : entities.stream().map(OrderRowDomainMapper::map).collect(Collectors.toList());
    }

}
