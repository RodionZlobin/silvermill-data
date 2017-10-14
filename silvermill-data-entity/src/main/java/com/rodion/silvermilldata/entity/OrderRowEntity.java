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
public class OrderRowEntity extends IdEntity<String> {

    @Id
    private String id;

    private String orderRowId;
    private String orderNumber;
    private String invoiceNumber;

    @DBRef
    private ProductEntity product;

    private String unit;
    private Double quantity;
    private Double price;
    private Double amount;

    protected OrderRowEntity() {
    }

    public OrderRowEntity(String orderRowId, String orderNumber, String invoiceNumber, String unit, Double quantity, Double price, Double amount) {
        this.orderRowId = orderRowId;
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    @PersistenceConstructor
    public OrderRowEntity(String orderRowId, String orderNumber, String invoiceNumber, ProductEntity product, String unit, Double quantity, Double price, Double amount) {
        this.orderRowId = orderRowId;
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
                "invoiceNumber" + invoiceNumber +
                "product=" + product.getProductName() + product.getProductColor() +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
