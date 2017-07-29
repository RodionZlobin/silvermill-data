package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Rodion
 */
public interface ProductDao extends MongoRepository<ProductEntity, String>{ //GenericDao<ProductEntity, String> {
    ProductEntity findByProductArticle(String productArticle);
    List<ProductEntity> findByProductName(String productName);
}
