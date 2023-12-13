package com.group.devops.model.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Schema(description = "House number or identifier", example = "123")
    private String houseNumber;

    @Schema(description = "First line of the address", example = "123 Main St")
    private String addressLine1;

    @Schema(description = "Second line of the address (optional)", example = "Apartment 4")
    private String addressLine2;

    @Schema(description = "County or regional division", example = "Suffolk")
    private String county;

    @Schema(description = "City or town", example = "Ipswich")
    private String city;

    @Schema(description = "Postal code", example = "IP1 1AA")
    private String postcode;

    @Schema(description = "Mobile phone number", example = "07700123456")
    private String mobile;

    @Schema(description = "Landline telephone number", example = "01473123456")
    private String telephone;

    @Schema(description = "Country", example = "United Kingdom")
    private String country;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "houseNumber=" + houseNumber + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", county=" + county + ", city=" + city + ", postcode=" + postcode + ", mobile=" + mobile + ", telephone=" + telephone + ", country=" + country + '}';
    }






}
