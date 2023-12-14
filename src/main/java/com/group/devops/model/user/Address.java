package com.group.devops.model.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Embeddable;

/**
 * Represents an address associated with a user.
 * Includes details such as house number, address lines, city, postcode, and contact numbers.
 */
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

    // Getters and setters with Javadoc comments

    /**
     * Gets the house number or identifier.
     *
     * @return The house number.
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the house number or identifier.
     *
     * @param houseNumber The house number to set.
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    // ... [similar comments for other getters and setters]

    /**
     * Provides a string representation of the address.
     *
     * @return A string describing the address.
     */
    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}