package com.pioneers.jpa.services.students;

import com.pioneers.jpa.errors.exceptions.CredentialsException;
import com.pioneers.jpa.errors.exceptions.LoginException;
import com.pioneers.jpa.errors.exceptions.LogoutException;
import com.pioneers.jpa.errors.exceptions.RegisterException;
import com.pioneers.jpa.models.dtos.requests.StudentLogin;
import com.pioneers.jpa.models.dtos.requests.StudentRegister;
import com.pioneers.jpa.models.dtos.responses.GenericResponse;
import jakarta.validation.constraints.Email;

import java.util.List;

/**
 * The service layer for authenticated services.
 *
 * @author abdelaziz
 * @see com.pioneers.jpa.services.students.AuthStudentServiceImpl
 */
public interface AuthStudentService {

    /**
     * Register a student into our system.
     *
     * @param studentRegisterRequest DTO that includes student info required for registration process.
     * @throws RegisterException if student already registered, or cannot hash the password.
     */
    void signup(StudentRegister studentRegisterRequest) throws RegisterException;

    /**
     * Login student in our system.
     *
     * @param studentLoginRequest DTO that includes required info for the login process.
     * @throws LoginException       if the student not registered, or already logged in, or password mismatched.
     * @throws CredentialsException if cannot hash the password.
     */
    void login(StudentLogin studentLoginRequest) throws LoginException, CredentialsException;

    /**
     * Logout student from our system.
     *
     * @param email provided email of the student need to log out.
     * @throws LogoutException if the student not registered.
     */
    void logout(@Email(message = "{validation.email.pattern}") String email) throws LogoutException;

    /**
     * Register multiple students into our system.
     *
     * @param studentRegisterRequests DTO that includes list of students info required for registration process.
     * @throws RegisterException if any student already registered, or cannot hash any student password.
     */
    GenericResponse<?> saveAll(final List<StudentRegister> studentRegisterRequests) throws RegisterException;
}
