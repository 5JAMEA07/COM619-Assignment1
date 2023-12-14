package com.group.devops.model.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity representing a geographical point on a map.
 * It includes details such as name, description, location coordinates (latitude and longitude),
 * and an optional photo URL.
 */
@Entity
public class MapPoint {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String description;
    private double lat;
    private double lng;
    private String photoUrl;

    /**
     * Default constructor for JPA entity initialization.
     */
    public MapPoint() {
        // Default constructor for JPA
    }

    /**
     * Constructs a new MapPoint with specified name, description, latitude, and longitude.
     *
     * @param name        The name of the map point.
     * @param description The description of the map point.
     * @param lat         The latitude of the map point.
     * @param lng         The longitude of the map point.
     */
    public MapPoint(String name, String description, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Gets the unique identifier of the map point.
     *
     * @return The ID of the map point.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the map point.
     *
     * @param id The ID to set for the map point.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username associated with the map point.
     *
     * @return The username.
     */
    public String getUserName() {
        return username;
    }

    /**
     * Sets the username associated with the map point.
     *
     * @param username The username to set.
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * Gets the name of the map point.
     *
     * @return The name of the map point.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the map point.
     *
     * @param name The name to set for the map point.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the map point.
     *
     * @return The description of the map point.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the map point.
     *
     * @param description The description to set for the map point.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the latitude of the map point.
     *
     * @return The latitude of the map point.
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the latitude of the map point.
     *
     * @param lat The latitude to set for the map point.
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets the longitude of the map point.
     *
     * @return The longitude of the map point.
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the longitude of the map point.
     *
     * @param lng The longitude to set for the map point.
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * Gets the photo URL of the map point.
     *
     * @return The photo URL.
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * Sets the photo URL of the map point.
     *
     * @param photoUrl The photo URL to set.
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "MapPoint {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
