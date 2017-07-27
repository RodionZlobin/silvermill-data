package com.rodion.silvermilldata.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class Order extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNumber;
    private Date orderDate;
    private String paymentTerms;
    private Customer customer;
    private DeliveryAddress deliveryAddress;
    private String deliveryTerms;
    private List<OrderRaw> orderRaws;
    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private String status;

    public Order(String orderNumber,
                 Date orderDate,
                 String paymentTerms,
                 Customer customer,
                 DeliveryAddress deliveryAddress,
                 String deliveryTerms,
                 List<OrderRaw> orderRaws,
                 String currency,
                 Integer VATRate,
                 Double amount,
                 Double totalAmount,
                 String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.paymentTerms = paymentTerms;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTerms = deliveryTerms;
        this.orderRaws = orderRaws;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    public List<OrderRaw> getOrderRaws() {
        return orderRaws;
    }

    public void setOrderRaws(List<OrderRaw> orderRaws) {
        this.orderRaws = orderRaws;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getVATRate() {
        return VATRate;
    }

    public void setVATRate(Integer VATRate) {
        this.VATRate = VATRate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{
                orderNumber,
                orderDate,
                paymentTerms,
                customer,
                deliveryAddress,
                deliveryTerms,
                orderRaws,
                currency,
                VATRate,
                amount,
                totalAmount,
                status
        };
    }
}