package com.group.devops.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class SignUpRequest {


    @Schema(description = "Username for the new user", example = "alice123")
    private String username;

    @Schema(description = "Password for the new user", example = "securePassword!")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
