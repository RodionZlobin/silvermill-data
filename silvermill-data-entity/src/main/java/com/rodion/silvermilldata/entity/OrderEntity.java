package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed(unique = true)
    private String orderNumber;

    private Date orderDate;
    private String paymentTerms;

    @DBRef
    private CustomerEntity customerEntity;

    @DBRef
    private DeliveryAddressEntity deliveryAddressEntity;

    private String deliveryTerms;

    @DBRef
    private List<OrderRawEntity> orderRaws;

    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private String status;

    protected OrderEntity(){}

    //needs for mapping
    public OrderEntity(String orderNumber,
                       Date orderDate,
                       String paymentTerms,
                       String deliveryTerms,
                       String currency,
                       Integer VATRate,
                       Double amount,
                       Double totalAmount,
                       String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.paymentTerms = paymentTerms;
        this.deliveryTerms = deliveryTerms;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    @PersistenceConstructor
    public OrderEntity(String orderNumber,
                       Date orderDate,
                       String paymentTerms,
                       CustomerEntity customerEntity,
                       DeliveryAddressEntity deliveryAddressEntity,
                       String deliveryTerms,
                       List<OrderRawEntity> orderRaws,
                       String currency,
                       Integer VATRate,
                       Double amount,
                       Double totalAmount,
                       String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.paymentTerms = paymentTerms;
        this.customerEntity = customerEntity;
        this.deliveryAddressEntity = deliveryAddressEntity;
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

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public DeliveryAddressEntity getDeliveryAddressEntity() {
        return deliveryAddressEntity;
    }

    public void setDeliveryAddressEntity(DeliveryAddressEntity deliveryAddressEntity) {
        this.deliveryAddressEntity = deliveryAddressEntity;
    }

    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    public List<OrderRawEntity> getOrderRaws() {
        return orderRaws;
    }

    public void setOrderRaws(List<OrderRawEntity> orderRaws) {
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

    public void setVATRate(Integer vatRate) {
        this.VATRate = vatRate;
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
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", customerEntity=" + customerEntity +
                ", orderRaws=" + orderRaws +
                ", amount=" + amount +
                '}';
    }
}
