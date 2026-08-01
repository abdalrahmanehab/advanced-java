package com.pioneers.universitysystem.models.dtos.requests;

import java.util.Date;
import java.util.Objects;

public class SignupRequest {
    final String fullName;
    final String email;
    final String username;
    final String password;
    final Date birthDate;

    public SignupRequest(String fullName, String email, String username, String password, Date birthDate) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SignupRequest that)) return false;
        return Objects.equals(email, that.email) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username);
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

