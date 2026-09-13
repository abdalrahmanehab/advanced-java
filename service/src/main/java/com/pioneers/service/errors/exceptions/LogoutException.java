package com.pioneers.service.errors.exceptions;

import com.pioneers.service.utils.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@EqualsAndHashCode(callSuper = false)
public class LogoutException extends RuntimeException {
    private final String description;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE = 4000;
    public static final String MESSAGE = "logoutError";

    public LogoutException(String description) {
        super(description);

        this.description = description;
    }
}
