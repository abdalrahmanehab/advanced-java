package com.pioneers.service.errors.handlers;

import com.pioneers.service.errors.exceptions.*;
import com.pioneers.service.errors.models.ErrorResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class StudentExceptionHandler {

    @ResponseBody
    @ExceptionHandler(exception = StudentException.class)
    public ErrorResponse<?> handleStudentException(final StudentException e) {
        return new ErrorResponse<>(
                StudentException.CODE,
                StudentException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }
}
