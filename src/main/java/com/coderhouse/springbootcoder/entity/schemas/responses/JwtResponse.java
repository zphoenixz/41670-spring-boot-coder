package com.coderhouse.springbootcoder.entity.schemas.responses;

import java.util.List;

public class JwtResponse {
    private String token;
    private String userId;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, String userId, String username, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }
}
