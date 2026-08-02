package com.pioneers.rest.utils.validators;

import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.pioneers.rest.utils.StringUtils.isNullOrBlank;

public class StudentValidator {
    public static Optional<ResponseEntity<Map<UUID, Student>>> validateStudentRegisterRequest(
            final StudentRegister studentRegisterRequest
    ) {
        if (isNullOrBlank(studentRegisterRequest.getFirstName())) {
            return Optional.of(ResponseEntity.badRequest().build());
        }

        if (isNullOrBlank(studentRegisterRequest.getSecondName())) {
            return Optional.of(ResponseEntity.badRequest().build());
        }

        if (isAgeMisaligned(studentRegisterRequest.getAge())) {
            return Optional.of(ResponseEntity.badRequest().build());
        }

        if (isEmailInvalid(studentRegisterRequest.getEmail())) {
            return Optional.of(ResponseEntity.badRequest().build());
        }

        if (isPasswordInvalid(studentRegisterRequest.getPassword())) {
            return Optional.of(ResponseEntity.badRequest().build());
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
        return age < 18 && age > 25;
    }
}
