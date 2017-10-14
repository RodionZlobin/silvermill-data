package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.entity.ProductEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class ProductDomainMapper {

    private ProductDomainMapper() {
    }

    public static Product map(ProductEntity productEntity){
        return productEntity == null ? null :
                new Product(productEntity.getProductId(),
                                        productEntity.getProductArticle(),
                                        productEntity.getProductName(),
                                        productEntity.getProductColor(),
                                        productEntity.getProductSalesPrice(),
                                        productEntity.getProductQuantity());
    }

    public static ProductEntity map(Product product){
        return product == null ? null :
                new ProductEntity(product.getProductId(),
                                    product.getProductArticle(),
                                    product.getProductName(),
                                    product.getProductColor(),
                                    product.getProductSalesPrice(),
                                    product.getProductQuantity());
    }

    public static List<Product> map(Collection<ProductEntity> entities){

        return entities == null ? null : entities.stream().map(ProductDomainMapper::map).collect(Collectors.toList());
    }

}
