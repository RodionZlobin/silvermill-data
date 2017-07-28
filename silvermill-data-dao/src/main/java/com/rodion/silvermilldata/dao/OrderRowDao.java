package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.OrderRowEntity;

import java.util.List;

/**
 * @author Rodion
 */
public interface OrderRowDao extends GenericDao<OrderRowEntity, String> {
    List<OrderRowEntity> findByOrderNumber(String orderNumber);
}
