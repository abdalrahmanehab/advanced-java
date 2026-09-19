package com.pioneers.service.errors.handlers;

import com.pioneers.service.errors.exceptions.*;
import com.pioneers.service.errors.models.ErrorResponse;
import com.pioneers.service.errors.models.GenericResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class StudentExceptionHandler {

    @ResponseBody
    @ExceptionHandler(exception = StudentException.class)
    public GenericResponse<ErrorResponse> handleStudentException(final StudentException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }
}
