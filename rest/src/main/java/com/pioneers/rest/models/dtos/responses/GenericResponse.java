package com.pioneers.rest.models.dtos.responses;

import java.util.Objects;

public class GenericResponse<T> {
    private final String message;
    private final T body;

    public GenericResponse(String message, T body) {
        this.message = message;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public T getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GenericResponse<?> that)) return false;
        return Objects.equals(message, that.message) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, body);
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
