package com.pioneers.service.utils.times;

import java.sql.Timestamp;
import java.time.Instant;

public final class TimeHelper {

    private TimeHelper() {
        throw new AssertionError("Utility Class");
    }

    public static Timestamp currentTimestamp() {
        return Timestamp.from(Instant.now());
    }
}
