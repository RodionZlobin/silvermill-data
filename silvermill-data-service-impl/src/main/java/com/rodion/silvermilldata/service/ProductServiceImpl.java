package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.ProductDao;
import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.entity.ProductEntity;
import com.rodion.silvermilldata.mapper.ProductDomainMapper;

import java.util.List;

/**
 * @author Rodion
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(Product product) {

        ProductEntity productEntity = ProductDomainMapper.map(product);
        return ProductDomainMapper.map(productDao.insert(productEntity));
    }

    @Override
    public Product findProductByProductArticle(String productArticle) {
        return ProductDomainMapper.map(productDao.findByProductArticle(productArticle));
    }

    @Override
    public List<Product> findProductsByProductName(String productName) {
        return ProductDomainMapper.map(productDao.findByProductName(productName));
    }

    @Override
    public List<Product> findAllProducts() {
        return ProductDomainMapper.map(productDao.findAll());
    }
}
