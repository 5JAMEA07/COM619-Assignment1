package com.group.devops.model.dto;

import com.group.devops.model.user.User;

public class LoginResponse {

    private String token;
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
