package com.pioneers.service.models.dtos.requests;

public record StudentLogin(String email, String password) {

    @Override
    public String toString() {
        return "StudentLogin{" +
                "email='" + email + '\'' +
                ", password='**********'" +
                '}';
    }
}
