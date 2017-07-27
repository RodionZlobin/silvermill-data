package com.rodion.silvermilldata.client;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.service.ProductService;

import java.util.List;

/**
 * @author Rodion
 */
public class ProductClientImpl implements ProductClient {

    private ProductService productService;

    public ProductClientImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product createOrUpdateProduct(Product product) {
        return productService.createOrUpdateProduct(product);
    }

    @Override
    public Product findByProductArticle(String productArticle) {
        return productService.findByProductArticle(productArticle);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productService.findByProductName(productName);
    }

    @Override
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
}
