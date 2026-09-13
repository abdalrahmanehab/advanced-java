package com.pioneers.service.services.students;

import com.pioneers.service.errors.exceptions.*;
import com.pioneers.service.models.dtos.requests.StudentLogin;
import com.pioneers.service.models.dtos.requests.StudentRegister;
import com.pioneers.service.models.dtos.responses.GenericResponse;

import java.util.List;

public interface AuthStudentService {

    void signup(final StudentRegister studentRegisterRequest) throws RegisterException, ValidationException;

    void login(final StudentLogin studentLoginRequest) throws LoginException, CredentialsException;

    void logout(final String email) throws LogoutException;

    GenericResponse<?> saveAll(final List<StudentRegister> studentRegisterRequests)
            throws RegisterException, ValidationException;
}
