package com.pioneers.datastructures.set;

import java.util.Objects;
import java.util.UUID;

public class TheInteger {

    private String id;
    private int value;

    private TheInteger(int value) {
        String id = UUID.randomUUID().toString();
        System.out.println("id = " + id);
        this.value = value;
        this.id = id;
    }

    public static TheInteger valueOf(final int value) {
        return new TheInteger(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TheInteger integer)) return false;
        return value == integer.value && Objects.equals(id, integer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
