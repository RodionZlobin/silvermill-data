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

    public static CustomerEntity updateCustomerEntity(CustomerEntity entity, Customer customer) {
        entity.setAddressEntity(AddressDomainMapper.map(customer.getAddress()));
        entity.setDeliveryAddressEntity(DeliveryAddressDomainMapper.map(customer.getDeliveryAddress()));
        return entity;
    }

    public static ProductEntity updateProductEntity(ProductEntity entity, Product product){
        entity.setProductName(product.getProductName());
        entity.setProductColor(product.getProductColor());
        entity.setProductSalesPrice(product.getProductSalesPrice());
        entity.setProductQuantity(product.getProductQuantity());
        return entity;
    }
}
