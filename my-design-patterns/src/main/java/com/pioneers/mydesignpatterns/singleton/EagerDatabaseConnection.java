package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerDatabaseConnection {
    private static final EagerDatabaseConnection INSTANCE = new EagerDatabaseConnection();

    private EagerDatabaseConnection() {
        log.info("Eager database connection is created !");
    }

    public static EagerDatabaseConnection getInstance() {
        return INSTANCE;
    }

    public void connect() {
        log.info("Connecting database using EagerDatabase connector ");
    }

}
