package com.pioneers.service.errors.exceptions;

import com.pioneers.service.utils.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Collection;

@Slf4j
@Getter
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException {

    private final String description;
    private final Collection<String> errors;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE = 2000;
    public static final String MESSAGE = "validationError";

    public ValidationException(String description, String logMessage, Collection<String> errors) {
        super(description);

        this.description = description;
        this.errors = errors;

        log.error(logMessage);
    }
}
