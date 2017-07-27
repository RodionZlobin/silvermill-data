package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class DeliveryAddressEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String deliveryAddressEntityId;

    public DeliveryAddressEntity(String deliveryAddressId) {
        this.deliveryAddressEntityId = deliveryAddressEntityId;
    }

    public String getDeliveryAddressEntityId() {
        return deliveryAddressEntityId;
    }

    public void setDeliveryAddressEntityId(String deliveryAddressEntityId) {
        this.deliveryAddressEntityId = deliveryAddressEntityId;
    }

    @Override
    public String getId() {
        return id;
    }
}
