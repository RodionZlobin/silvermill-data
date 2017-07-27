package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class Address extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String addressId;

    public Address(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{addressId};
    }
}
