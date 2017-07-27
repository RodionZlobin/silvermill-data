package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class DeliveryAddress extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String deliveryAddressId;

    public DeliveryAddress(String deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public String getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(String deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{deliveryAddressId};
    }
}
