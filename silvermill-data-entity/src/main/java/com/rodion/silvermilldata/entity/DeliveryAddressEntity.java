package com.rodion.silvermilldata.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rodion
 */

@Document(collection = "deliveryAddresses")
public class DeliveryAddressEntity extends AddressEntity {//IdEntity<String> {


    public DeliveryAddressEntity() {
    }

    public DeliveryAddressEntity(String addressId, String addressName, String street, String building, String city, String zipCode, String country, String postBox) {
        super(addressId, addressName, street, building, city, zipCode, country, postBox);
    }

    /*

        @Id
        private String id;

        @Indexed(unique = true)
        private String deliveryAddressId;

        @Indexed(unique = true)
        private String deliveryAddressName;

        private String street;
        private String building;
        private String city;
        private String zipCode;
        private String country;
        private String postBox;

        protected DeliveryAddressEntity(){}

        @PersistenceConstructor
        public DeliveryAddressEntity(String deliveryAddressId, String deliveryAddressName, String street, String building, String city, String zipCode, String country, String postBox) {
            this.deliveryAddressId = deliveryAddressId;
            this.deliveryAddressName = deliveryAddressName;
            this.street = street;
            this.building = building;
            this.city = city;
            this.zipCode = zipCode;
            this.country = country;
            this.postBox = postBox;
        }

        public String getDeliveryAddressId() {
            return deliveryAddressId;
        }

        public void setDeliveryAddressId(String deliveryAddressId) {
            this.deliveryAddressId = deliveryAddressId;
        }

        public String getDeliveryAddressName() {
            return deliveryAddressName;
        }

        public void setDeliveryAddressName(String deliveryAddressName) {
            this.deliveryAddressName = deliveryAddressName;
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

         */
    @Override
    public String toString() {
        return "DeliveryAddressEntity{" +
                "street='" + super.getStreet() + '\'' +
                ", building='" + super.getBuilding() + '\'' +
                ", city='" + super.getCity() + '\'' +
                ", zipCode='" + super.getZipCode() + '\'' +
                ", country='" + super.getCountry() + '\'' +
                ", postBox='" + super.getPostBox() + '\'' +
                '}';
    }
}
