package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Rodion
 */

@Document(collection = "customers")
public class CustomerEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed(unique = true)
    private String customerId;

    @Indexed(unique = true)
    private String customerName;

    @Indexed(unique = true)
    private String customerVAT;

    @Indexed(unique = true)
    private String customerRegNumber;

    @DBRef
    private AddressEntity addressEntity;

    @DBRef
    private DeliveryAddressEntity deliveryAddressEntity;

    protected CustomerEntity(){}

    //needs for mapping
    public CustomerEntity(String customerId, String customerName, String customerVAT, String customerRegNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerVAT = customerVAT;
        this.customerRegNumber = customerRegNumber;
    }

    @PersistenceConstructor
    public CustomerEntity(String customerId, String customerName, String customerVAT, String customerRegNumber, AddressEntity addressEntity, DeliveryAddressEntity deliveryAddressEntity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerVAT = customerVAT;
        this.customerRegNumber = customerRegNumber;
        this.addressEntity = addressEntity;
        this.deliveryAddressEntity = deliveryAddressEntity;
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public DeliveryAddressEntity getDeliveryAddressEntity() {
        return deliveryAddressEntity;
    }

    public void setDeliveryAddressEntity(DeliveryAddressEntity deliveryAddressEntity) {
        this.deliveryAddressEntity = deliveryAddressEntity;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerVAT='" + customerVAT + '\'' +
                ", customerRegNumber='" + customerRegNumber + '\'' +
                ", addressEntity=" + addressEntity +
                ", deliveryAddressEntity=" + deliveryAddressEntity +
                '}';
    }
}
