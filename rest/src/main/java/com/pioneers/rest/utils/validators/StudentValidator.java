package com.pioneers.rest.utils.validators;

import com.pioneers.rest.models.dtos.requests.StudentRegister;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static com.pioneers.rest.utils.StringUtils.isNullOrBlank;

public class StudentValidator {
    public static Optional<ResponseEntity<?>> validateStudentRegisterRequest(
            final StudentRegister studentRegisterRequest
    ) {
        if (isNullOrBlank(studentRegisterRequest.getFirstName())) {
            return Optional.of(ResponseEntity.badRequest().body("Validation Error: First name cannot be empty"));
        }

        if (isNullOrBlank(studentRegisterRequest.getSecondName())) {
            return Optional.of(ResponseEntity.badRequest().body("Validation Error: Second name cannot be empty"));
        }

        if (isAgeMisaligned(studentRegisterRequest.getAge())) {
            return Optional.of(ResponseEntity.badRequest().body("Validation Error: Age must be between 18 and 25"));
        }

        if (isEmailInvalid(studentRegisterRequest.getEmail())) {
            return Optional.of(ResponseEntity.badRequest().body("Validation Error: Invalid email format"));
        }

        if (isPasswordInvalid(studentRegisterRequest.getPassword())) {
            return Optional.of(ResponseEntity.badRequest().body("Validation Error: Password must be between 8 and 32 characters"));
        }

        return Optional.empty();
    }

    private static boolean isPasswordInvalid(final String password) {
        return isNullOrBlank(password) || password.length() < 8 || password.length() > 32;
    }

    private static boolean isEmailInvalid(final String email) {
        return isNullOrBlank(email) || !email.contains("@");
    }

    private static boolean isAgeMisaligned(final int age) {
        return age < 18 || age > 25;
    }
}