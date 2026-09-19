package com.pioneers.service.errors.handlers;

import com.pioneers.service.errors.models.ErrorResponse;
import com.pioneers.service.errors.models.GenericResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.MaterializedNode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static com.pioneers.service.utils.times.TimeHelper.currentTimestamp;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public GenericResponse<List<ErrorResponse>> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        final List<ErrorResponse> errorResponseList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::from)
                .toList();

        return new GenericResponse<>(9000, currentTimestamp(), errorResponseList);
    }

    private ErrorResponse from(final FieldError fieldError) {
        return new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = ConstraintViolationException.class)
    public void handleConstraintViolationException(final ConstraintViolationException e) {
        System.out.println(e.getConstraintViolations().stream()
                .toList()
                .get(0)
                .getMessage());
        System.out.println(((MaterializedNode) e.getConstraintViolations().stream()
                .toList()
                .get(0)
                .getPropertyPath())
                .getName()
        );
    }
}
