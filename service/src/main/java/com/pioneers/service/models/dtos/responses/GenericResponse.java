package com.pioneers.service.models.dtos.responses;

public record GenericResponse<T>(String message, T body) {
}
