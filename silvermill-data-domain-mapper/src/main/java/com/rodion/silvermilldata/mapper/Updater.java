package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.ProductEntity;
import com.rodion.silvermilldata.entity.UserEntity;

/**
 * @author Rodion
 */
public class Updater {
    public static UserEntity updateUserEntity(UserEntity entity, User user){
        entity.setPassword(user.getPassword());
        return entity;
    }

    public static ProductEntity updateProductEntity(ProductEntity entity, Product product){
        entity.setProductSalesPrice(product.getProductSalesPrice());
        entity.setProductQuantity(product.getProductQuantity());
        return entity;
    }
}
