package com.group.devops.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a request for user login, containing the username and password.
 */
public class LoginRequest {

    @Schema(description = "Username of the user", example = "john_doe")
    private String username;

    @Schema(description = "Password of the user", example = "password123")
    private String password;

    /**
     * Retrieves the username associated with this login request.
     *
     * @return The username of the user attempting to log in.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password associated with this login request.
     *
     * @return The password of the user attempting to log in.
     */
    public String getPassword() {
        return password;
    }
}
