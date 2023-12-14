package com.group.devops.model.dto;

import com.group.devops.model.user.User;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the response returned upon a successful user login.
 * It includes the authentication token and user details.
 */
public class LoginResponse {

    @Schema(description = "Authentication token provided after successful login",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "User details associated with the authenticated session")
    private User user;

    /**
     * Constructs a new LoginResponse with the specified token and user details.
     *
     * @param token The authentication token.
     * @param user  The user details associated with the authenticated session.
     */
    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    /**
     * Retrieves the authentication token.
     *
     * @return The authentication token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the authentication token.
     *
     * @param token The authentication token to be set.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Retrieves the user details.
     *
     * @return The user details.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user details.
     *
     * @param user The user details to be set.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
