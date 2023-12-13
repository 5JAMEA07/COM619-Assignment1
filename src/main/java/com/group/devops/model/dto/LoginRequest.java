package com.group.devops.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginRequest {

    @Schema(description = "Username of the user", example = "john_doe")
    private String username;

    @Schema(description = "Password of the user", example = "password123")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
