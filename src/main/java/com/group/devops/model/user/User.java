package com.group.devops.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group.devops.utils.PasswordUtils;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Embedded;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the user", example = "1")
    private Long id;

    @Schema(description = "First name of the user", example = "John")
    private String firstName = "";

    @Schema(description = "Second name of the user", example = "Doe")
    private String secondName = "";

    @Schema(description = "Username for the user", example = "johndoe123")
    private String username = "";

    @Transient
    @Schema(description = "Password of the user (transient, not stored in DB)", example = "password")
    private String password = "";

    @JsonIgnore
    @Schema(hidden = true)
    private String hashedPassword = "";

    @Embedded
    @Schema(description = "Address details of the user")
    private Address address;

    @Schema(description = "Role of the user in the system", example = "ADMIN")
    private UserRole userRole;

    @Schema(description = "Flag indicating whether the user account is enabled", example = "true")
    private Boolean enabled = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    @Transient
    public String getPassword() {
        return password;
    }

    // generate hashed password to save in database
    public void setPassword(String password) {
        this.password = password;
        setHashedPassword(PasswordUtils.hashPassword(password));
    }

    public boolean isValidPassword(String checkPassword) {
        if (checkPassword == null || getHashedPassword() == null) {
            return false;
        }
        return PasswordUtils.checkPassword(checkPassword, getHashedPassword());
    }

    @JsonIgnore
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    // no password or hashed password
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", username=" + username + ", password=NOT SHOWN, address=" + address + ", userRole=" + userRole + '}';
    }

}
