package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.ProductEntity;

import java.util.List;

/**
 * @author Rodion
 */
public interface ProductDao extends GenericDao<ProductEntity, String> {
    ProductEntity findByProductArticle(String productArticle);
    List<ProductEntity> findByProductName(String productName);
}
