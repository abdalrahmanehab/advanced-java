package com.pioneers.service.errors.handlers;

import com.pioneers.service.errors.exceptions.CredentialsException;
import com.pioneers.service.errors.exceptions.LoginException;
import com.pioneers.service.errors.exceptions.LogoutException;
import com.pioneers.service.errors.exceptions.RegisterException;
import com.pioneers.service.errors.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class AuthStudentHandler {

    @ExceptionHandler(exception = RegisterException.class)
    public ErrorResponse<?> handleRegisterException(final RegisterException e) {
        return new ErrorResponse<>(
                RegisterException.CODE,
                RegisterException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = LogoutException.class)
    public ErrorResponse<?> handleLogoutException(final LogoutException e) {
        return new ErrorResponse<>(
                LogoutException.CODE,
                LogoutException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = LoginException.class)
    public ErrorResponse<?> handleLoginException(final LoginException e) {
        return new ErrorResponse<>(
                LoginException.CODE,
                LoginException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = CredentialsException.class)
    public ErrorResponse<?> handleCredentialsException(final CredentialsException e) {
        return new ErrorResponse<>(
                CredentialsException.CODE,
                CredentialsException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }
}
