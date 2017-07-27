package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class Customer extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerId;
    private String customerName;
    private String customerVAT;
    private String customerRegNumber;
    private Address address;
    private DeliveryAddress deliveryAddress;

    public Customer(String customerId,
                    String customerName,
                    String customerVAT,
                    String customerRegNumber,
                    Address address,
                    DeliveryAddress deliveryAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerVAT = customerVAT;
        this.customerRegNumber = customerRegNumber;
        this.address = address;
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerVAT() {
        return customerVAT;
    }

    public void setCustomerVAT(String customerVAT) {
        this.customerVAT = customerVAT;
    }

    public String getCustomerRegNumber() {
        return customerRegNumber;
    }

    public void setCustomerRegNumber(String customerRegNumber) {
        this.customerRegNumber = customerRegNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{customerId, customerName, customerVAT, customerRegNumber, address, deliveryAddress};
    }
}
