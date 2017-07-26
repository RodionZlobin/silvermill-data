package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Product;

import java.util.List;

/**
 * @author Rodion
 */
public interface ProductClient {
    Product createProduct(Product product);
    Product findProductByProductArticle(String productArticle);
    List<Product> findProductsByProductName(String productName);
    List<Product> findAllProducts();
}
