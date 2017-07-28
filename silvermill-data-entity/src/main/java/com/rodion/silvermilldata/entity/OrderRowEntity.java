package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Rodion
 */

@Document(collection = "orderRows")
public class OrderRowEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String orderRowId;
    private String orderNumber;

    @DBRef
    private ProductEntity product;

    private String unit;
    private Double quantity;
    private Double price;
    private Double amount;

    protected OrderRowEntity() {
    }

    public OrderRowEntity(String orderRowId, String orderNumber, String unit, Double quantity, Double price, Double amount) {
        this.orderRowId = orderRowId;
        this.orderNumber = orderNumber;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    @PersistenceConstructor
    public OrderRowEntity(String orderRowId, String orderNumber, ProductEntity product, String unit, Double quantity, Double price, Double amount) {
        this.orderRowId = orderRowId;
        this.orderNumber = orderNumber;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getOrderRowId() {
        return orderRowId;
    }

    public void setOrderRowId(String orderRowId) {
        this.orderRowId = orderRowId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderRowEntity{" +
                "orderNumber=" + orderNumber +
                "product=" + product.getProductName() + product.getProductColor() +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
