package com.pioneers.rest.configs.db;

import java.util.Objects;

public class ConnectionPool {
    private final int maxOpenConnections;
    private final int maxIdleConnections;
    private final int timeout;

    public ConnectionPool(int maxOpenConnections, int maxIdleConnections, int timeout) {
        this.maxOpenConnections = maxOpenConnections;
        this.maxIdleConnections = maxIdleConnections;
        this.timeout = timeout;
    }

    public int getMaxOpenConnections() {
        return maxOpenConnections;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConnectionPool that)) return false;
        return maxOpenConnections == that.maxOpenConnections
                && maxIdleConnections == that.maxIdleConnections
                && timeout == that.timeout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxOpenConnections, maxIdleConnections, timeout);
    }
}
