package com.group.devops.model.dto;

import com.group.devops.model.user.User;
import io.swagger.v3.oas.annotations.media.Schema;

public class LoginResponse {

    @Schema(description = "Authentication token provided after successful login", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "User details associated with the authenticated session")
    private User user;

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
