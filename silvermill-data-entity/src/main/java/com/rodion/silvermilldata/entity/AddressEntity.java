package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class AddressEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String AddressEntityId;

    public AddressEntity(String AddressEntityId) {
        this.AddressEntityId = AddressEntityId;
    }

    public String getAddressEntityId() {
        return AddressEntityId;
    }

    public void setAddressEntityId(String addressEntityId) {
        this.AddressEntityId = addressEntityId;
    }

    @Override
    public String getId() {
        return id;
    }
}
