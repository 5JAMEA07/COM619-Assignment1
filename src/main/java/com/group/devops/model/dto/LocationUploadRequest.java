package com.group.devops.model.dto;

import javax.validation.constraints.NotNull;

/**
 * Represents a request to upload a geographic location.
 * Contains details such as latitude, longitude, and associated user information.
 */
public class LocationUploadRequest {

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String description;

    /**
     * Constructs a new LocationUploadRequest with the specified details.
     *
     * @param latitude    The latitude of the location.
     * @param longitude   The longitude of the location.
     * @param username    The username of the user uploading the location.
     * @param name        The name of the location.
     * @param description The description of the location.
     */
    public LocationUploadRequest(double latitude, double longitude, String username, String name, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.username = username;
        this.name = name;
        this.description = description;
    }

    // Getters and setters with Javadoc comments
    /**
     * Returns the latitude of this location.
     * @return the latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of this location.
     * @param latitude the latitude to set.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the longitude of this location.
     * @return the longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of this location.
     * @param longitude the longitude to set.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the username of the user uploading the location.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user uploading the location.
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the name of the location.
     * @return the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location.
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the location.
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the location.
     * @param description the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
