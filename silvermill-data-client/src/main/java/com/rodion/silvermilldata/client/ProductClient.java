package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Product;

import java.util.List;

/**
 * @author Rodion
 */
public interface ProductClient {
    Product createOrUpdateProduct(Product product);
    Product findByProductArticle(String productArticle);
    List<Product> findByProductName(String productName);
    List<Product> findAllProducts();
}
