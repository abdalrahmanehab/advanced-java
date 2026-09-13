package com.pioneers.service.errors.handlers;

import com.pioneers.service.errors.exceptions.ValidationException;
import com.pioneers.service.errors.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(exception = ValidationException.class)
    public ErrorResponse<Collection<String>> handleValidationException(final ValidationException e) {
        return new ErrorResponse<>(
                ValidationException.CODE,
                ValidationException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.of(e.getErrors())
        );
    }
}
