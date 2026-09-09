package com.pioneers.rest.configs.db;

public record ConnectionPool(int maxOpenConnections, int maxIdleConnections, int timeout) {
}
