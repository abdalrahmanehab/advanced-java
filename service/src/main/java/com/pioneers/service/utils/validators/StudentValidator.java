package com.pioneers.service.utils.validators;

import com.pioneers.service.models.dtos.requests.StudentRegister;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

import static com.pioneers.service.utils.StringUtils.isNullOrBlank;

public final class StudentValidator {

    private StudentValidator() {
        throw new AssertionError("Cannot be instantiated");
    }

    // TODO: Enhance the following method not to violate the OCP
    public static List<String> validateStudentRegisterRequest(final StudentRegister studentRegisterRequest) {
        final List<String> errors = new LinkedList<>();

        if (isNullOrBlank(studentRegisterRequest.firstName())) {
            errors.add("First name is required");
        }

        if (isNullOrBlank(studentRegisterRequest.secondName())) {
            errors.add("Second name is required");
        }

        if (studentRegisterRequest.isAgeMisaligned(studentRegisterRequest.age())) {
            errors.add("Age is misaligned");
        }

        if (isEmailInvalid(studentRegisterRequest.email())) {
            errors.add("Email is invalid");
        }

        if (isPasswordInvalid(studentRegisterRequest.password())) {
            errors.add("Password is invalid");
        }

        return errors;
    }

    private static boolean isPasswordInvalid(final String password) {
        return isNullOrBlank(password) || password.length() < 8 || password.length() > 32;
    }

    private static boolean isEmailInvalid(final String email) {
        return isNullOrBlank(email) || !email.contains("@");
    }
}
