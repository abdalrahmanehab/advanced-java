package com.pioneers.functionalprogramming.tasks.regestration.utils;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("Utility Class");
    }

    public static boolean isNullOrBlank(final String name) {
        return name == null || name.isBlank();
    }
}
