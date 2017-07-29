package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.ProductEntity;
import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author Rodion
 */
public class ProductDaoImpl { //extends AbstractDao<ProductEntity, String> implements ProductDao {

    /*
    public ProductDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }

    @Override
    public ProductEntity findByProductArticle(String productArticle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productArticle").is(productArticle));
        return mongoOperations.findOne(query, ProductEntity.class);
    }

    @Override
    public List<ProductEntity> findByProductName(String productName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productName").is(productName));
        return mongoOperations.find(query, ProductEntity.class);
    }

    @Override
    public boolean isExists(String productArticle, Class<ProductEntity> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productArticle").is(productArticle));
        return mongoOperations.exists(query, entityClass);
    }
     */
}
