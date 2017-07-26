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
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @Override
    public Product findProductByProductArticle(String productArticle) {
        return productService.findProductByProductArticle(productArticle);
    }

    @Override
    public List<Product> findProductsByProductName(String productName) {
        return productService.findProductsByProductName(productName);
    }

    @Override
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
}
