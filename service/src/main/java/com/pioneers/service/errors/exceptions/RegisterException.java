package com.pioneers.service.errors.exceptions;

import com.pioneers.service.utils.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterException extends RuntimeException {

    private final String description;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE = 3000;
    public static final String MESSAGE = "registrationError";

    public RegisterException(String description, String logMessage) {
        super(description);

        this.description = description;

        log.error(logMessage);
    }
}
