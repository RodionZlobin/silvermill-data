package com.rodion.silvermilldata.domain;

/**
 * @author Rodion
 */
public class InvoiceAddress extends Address{ //ValueObject {

    public InvoiceAddress(String addressId, String addressName, String street, String building, String city, String zipCode, String country, String postBox) {
        super(addressId, addressName, street, building, city, zipCode, country, postBox);
    }


    /*

    private static final long serialVersionUID = 1L;

    private String addressId;
    private String addressName;
    private String street;
    private String building;
    private String city;
    private String zipCode;
    private String country;
    private String postBox;

    public InvoiceAddress(String addressId, String addressName, String street, String building, String city, String zipCode, String country, String postBox) {
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
    protected Object[] getIdFields() {
        return new Object[]{addressId, addressName, street, building, city, zipCode, country, postBox};
    }
     */
}
