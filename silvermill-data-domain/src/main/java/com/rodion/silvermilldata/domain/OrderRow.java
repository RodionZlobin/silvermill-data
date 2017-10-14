package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class OrderRow extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String orderRowId;
    private String orderNumber;
    private String invoiceNumber;
    private Product product;
    private String unit;
    private Double quantity;
    private Double price;
    private Double amount;

    public OrderRow(String orderRowId, String orderNumber, String invoiceNumber, Product product, String unit, Double quantity, Double price, Double amount) {
        this.orderRowId = orderRowId;
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
    protected Object[] getIdFields() {
        return new Object[]{orderRowId, orderNumber, invoiceNumber, product, unit, quantity, price, amount};
    }
}
