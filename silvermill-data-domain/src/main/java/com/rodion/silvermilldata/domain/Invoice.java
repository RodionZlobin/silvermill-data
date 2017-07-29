package com.rodion.silvermilldata.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class Invoice extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String invoiceNumber;
    private Date invoiceDate;
    private Date dueDate;
    private Customer customer;
    private DeliveryAddress deliveryAddress;
    private String deliveryTerms;
    private String countryOfOrigin;
    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private List<OrderRow> orderRows;
    private String status;
    private String totalAmountInWords;
    private String reducedVATNotification;

    public Invoice(String invoiceNumber,
                   Date invoiceDate,
                   Date dueDate,
                   Customer customer,
                   DeliveryAddress deliveryAddress,
                   String deliveryTerms,
                   String countryOfOrigin,
                   String currency,
                   Integer VATRate,
                   Double amount,
                   Double totalAmount,
                   List<OrderRow> orderRows,
                   String status,
                   String totalAmountInWords,
                   String reducedVATNotification) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTerms = deliveryTerms;
        this.countryOfOrigin = countryOfOrigin;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.orderRows = orderRows;
        this.status = status;
        this.totalAmountInWords = totalAmountInWords;
        this.reducedVATNotification = reducedVATNotification;
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

    public List<OrderRow> getOrderRows() {
        return orderRows;
    }

    public void setOrderRows(List<OrderRow> orderRows) {
        this.orderRows = orderRows;
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

    @Override
    protected Object[] getIdFields() {
        return new Object[]{
                invoiceNumber,
                invoiceDate,
                dueDate,
                customer,
                deliveryAddress,
                deliveryTerms,
                countryOfOrigin,
                currency,
                VATRate,
                amount,
                totalAmount,
                orderRows,
                status,
                totalAmountInWords,
                reducedVATNotification
        };
    }
}
