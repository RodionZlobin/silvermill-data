package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public abstract class AddressEntity extends IdEntity<String> {

    @Id
    private String id;

    @Indexed(unique = true)
    private String addressId;

    @Indexed(unique = true)
    private String addressName;

    private String street;
    private String building;
    private String city;
    private String zipCode;
    private String country;
    private String postBox;

    protected AddressEntity(){}

    @PersistenceConstructor
    public AddressEntity(String addressId, String addressName, String street, String building, String city, String zipCode, String country, String postBox) {
        this.addressId = addressId;
        this.addressName = addressName;
        this.street = street;
        this.building = building;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.postBox = postBox;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostBox() {
        return postBox;
    }

    public void setPostBox(String postBox) {
        this.postBox = postBox;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", postBox='" + postBox + '\'' +
                '}';
    }
}
