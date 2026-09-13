package com.pioneers.service.models.dtos.requests;

public record StudentRegister(String firstName, String secondName, int age, String email, String password) {

    public boolean isAgeMisaligned(final int age) {
        return age < 18 || age > 25;
    }
}
