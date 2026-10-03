package com.pioneers.functionalprogramming.tasks.regestration.services;

import com.pioneers.functionalprogramming.tasks.regestration.models.dtos.requests.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static com.pioneers.functionalprogramming.tasks.regestration.utils.StringUtils.isNullOrBlank;

@Service
public class StudentRegistrationService {
    private static final Predicate<String> VALID_NAME
            = name -> !isNullOrBlank(name) && name.length() > 3 && name.length() < 20;

    private static final Predicate<Integer> VALID_AGE = age -> age > 18 && age < 25;

    public RegistrationResult register(final RegistrationRequest registrationRequest) {
        if (!VALID_NAME.test(registrationRequest.name())) {
            return new RegistrationResult.Failure("Name must be from 3 to 20");
        }

        if (!VALID_AGE.test(registrationRequest.age())) {
            return new RegistrationResult.Failure("Age must be from 18 to 25");
        }

        final String successMessage
                = String.format("Successfully Registered student with name: [%s]", registrationRequest.name());

        return new RegistrationResult.Success(successMessage);
    }
}
