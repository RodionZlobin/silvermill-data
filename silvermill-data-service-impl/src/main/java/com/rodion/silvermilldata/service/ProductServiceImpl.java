package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.ProductDao;
import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.entity.ProductEntity;
import com.rodion.silvermilldata.mapper.ProductDomainMapper;
import com.rodion.silvermilldata.mapper.Updater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rodion
 */
public class ProductServiceImpl implements ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createOrUpdateProduct(Product productRequest) {

        ProductEntity productEntity;
        if(exists(productRequest))
        {
            ProductEntity productEntityFromDB = productDao.findByProductArticle(productRequest.getProductArticle());
            productEntity = Updater.updateProductEntity(productEntityFromDB, productRequest);
        }
        else{
            productEntity = ProductDomainMapper.map(productRequest);
        }

        return ProductDomainMapper.map(productDao.save(productEntity));
    }

    @Override
    public Product findByProductArticle(String productArticle) {
        return ProductDomainMapper.map(productDao.findByProductArticle(productArticle));
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return ProductDomainMapper.map(productDao.findByProductName(productName));
    }

    @Override
    public List<Product> findAllProducts() {
        return ProductDomainMapper.map(productDao.findAll());
    }

    private boolean exists(Product productRequest) {

        ProductEntity productEntity;
        try{
            productEntity = productDao.findByProductArticle(productRequest.getProductArticle());

        }
        catch (Exception e){
            LOGGER.error(String.format("Product '%s' is not exists", productRequest.getProductArticle()), e);
            throw e;
        }

        return (productEntity != null);
    }
}
