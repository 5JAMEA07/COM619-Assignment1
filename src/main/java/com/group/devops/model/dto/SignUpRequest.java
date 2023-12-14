package com.group.devops.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a request for signing up a new user, containing the username and password.
 */
public class SignUpRequest {

    @Schema(description = "Username for the new user", example = "alice123")
    private String username;

    @Schema(description = "Password for the new user", example = "securePassword!")
    private String password;

    /**
     * Retrieves the username of the new user.
     *
     * @return The username for the signup request.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the new user.
     *
     * @return The password for the signup request.
     */
    public String getPassword() {
        return password;
    }
}
