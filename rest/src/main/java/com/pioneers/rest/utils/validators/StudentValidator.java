package com.pioneers.rest.utils.validators;

import com.pioneers.rest.models.dtos.requests.StudentRegister;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

import static com.pioneers.rest.utils.StringUtils.isNullOrBlank;

public final class StudentValidator {

    private StudentValidator() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static ResponseEntity<List<String>> validateStudentRegisterRequest(
            final StudentRegister studentRegisterRequest
    ) {
        final List<String> errors = new LinkedList<>();

        if (isNullOrBlank(studentRegisterRequest.getFirstName())) {
            errors.add("First name is required");
        }

        if (isNullOrBlank(studentRegisterRequest.getSecondName())) {
            errors.add("Second name is required");
        }

        if (studentRegisterRequest.isAgeMisaligned(studentRegisterRequest.getAge())) {
            errors.add("Age is misaligned");
        }

        if (isEmailInvalid(studentRegisterRequest.getEmail())) {
            errors.add("Email is invalid");
        }

        if (isPasswordInvalid(studentRegisterRequest.getPassword())) {
            errors.add("Password is invalid");
        }

        return ResponseEntity.badRequest().body(errors);
    }

    private static boolean isPasswordInvalid(final String password) {
        return isNullOrBlank(password) || password.length() < 8 || password.length() > 32;
    }

    private static boolean isEmailInvalid(final String email) {
        return isNullOrBlank(email) || !email.contains("@");
    }
}
