package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */

@Document(collection = "invoices")
public class InvoiceEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed(unique = true)
    private String invoiceNumber;

    private Date invoiceDate;
    private Date dueDate;
    private CustomerEntity customerEntity;
    private DeliveryAddressEntity deliveryAddressEntity;
    private String deliveryTerms;
    private String countryOfOrigin;
    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private List<OrderRowEntity> orderRaws;
    private String status;
    private String totalAmountInWords;
    private String reducedVATNotification;
    private List<OrderEntity> orders;

    public InvoiceEntity(String invoiceNumber,
                         Date invoiceDate,
                         Date dueDate,
                         CustomerEntity customerEntity,
                         DeliveryAddressEntity deliveryAddressEntity,
                         String deliveryTerms,
                         String countryOfOrigin,
                         String currency,
                         Integer VATRate,
                         Double amount,
                         Double totalAmount,
                         List<OrderRowEntity> orderRaws,
                         String status,
                         String totalAmountInWords,
                         String reducedVATNotification,
                         List<OrderEntity> orders) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.customerEntity = customerEntity;
        this.deliveryAddressEntity = deliveryAddressEntity;
        this.deliveryTerms = deliveryTerms;
        this.countryOfOrigin = countryOfOrigin;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.orderRaws = orderRaws;
        this.status = status;
        this.totalAmountInWords = totalAmountInWords;
        this.reducedVATNotification = reducedVATNotification;
        this.orders = orders;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
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

    public List<OrderRowEntity> getOrderRaws() {
        return orderRaws;
    }

    public void setOrderRaws(List<OrderRowEntity> orderRaws) {
        this.orderRaws = orderRaws;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalAmountInWords() {
        return totalAmountInWords;
    }

    public void setTotalAmountInWords(String totalAmountInWords) {
        this.totalAmountInWords = totalAmountInWords;
    }

    public String getReducedVATNotification() {
        return reducedVATNotification;
    }

    public void setReducedVATNotification(String reducedVATNotification) {
        this.reducedVATNotification = reducedVATNotification;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InvoiceEntity{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", customerEntity=" + customerEntity.getCustomerName() +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
