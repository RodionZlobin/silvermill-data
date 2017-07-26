package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class Product extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;
    private String productArticle;
    private String productName;
    private String productColor;
    private Double productSalesPrice;
    private Integer productQuantity;

    public Product(String productId,
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
    protected Object[] getIdFields() {
        return new Object[]{productId, productArticle, productName, productColor, productSalesPrice, productQuantity};
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
}
