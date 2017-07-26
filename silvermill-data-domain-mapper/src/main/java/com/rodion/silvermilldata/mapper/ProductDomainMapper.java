package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class ProductDomainMapper {

    public static Product map(ProductEntity productEntity){
        return new Product(productEntity.getProductId(),
                                        productEntity.getProductArticle(),
                                        productEntity.getProductName(),
                                        productEntity.getProductColor(),
                                        productEntity.getProductSalesPrice(),
                                        productEntity.getProductQuantity());
    }

    public static ProductEntity map(Product product){
        return new ProductEntity(product.getProductId(),
                                    product.getProductArticle(),
                                    product.getProductName(),
                                    product.getProductColor(),
                                    product.getProductSalesPrice(),
                                    product.getProductQuantity());
    }

    public static List<Product> map(List<ProductEntity> entities){
        List<Product> products = new ArrayList<>();
        entities.forEach(p -> products.add(ProductDomainMapper.map(p)));
        return products;
    }

}
