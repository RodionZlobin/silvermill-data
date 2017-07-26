package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class ProductEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed(unique = true)
    private String productId;

    @Indexed(unique = true)
    private String productArticle;

    private String productName;
    private String productColor;
    private Double productSalesPrice;
    private Integer productQuantity;

    protected ProductEntity(){}

    @PersistenceConstructor
    public ProductEntity(String productId,
                         String productArticle,
                         String productName,
                         String productColor,
                         Double productSalesPrice,
                         Integer productQuantity) {
        this.productId = productId;
        this.productArticle = productArticle;
        this.productName = productName;
        this.productColor = productColor;
        this.productSalesPrice = productSalesPrice;
        this.productQuantity = productQuantity;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductArticle() {
        return productArticle;
    }

    public void setProductArticle(String productArticle) {
        this.productArticle = productArticle;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Double getProductSalesPrice() {
        return productSalesPrice;
    }

    public void setProductSalesPrice(Double productSalesPrice) {
        this.productSalesPrice = productSalesPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId='" + productId + '\'' +
                ", productArticle='" + productArticle + '\'' +
                ", productName='" + productName + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productSalesPrice=" + productSalesPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
