package com.pioneers.universitysystem.models.dtos.requests;

import java.util.Objects;

public class LoginRequest {
    final String username;
    final String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginRequest that)) return false;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
