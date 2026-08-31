package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyDatabaseConnection {
    private static LazyDatabaseConnection INSTANCE;

    private LazyDatabaseConnection() {
        log.info("compiling the lazy database connection without initializing the INSTANCE");
    }


    public static LazyDatabaseConnection getInstance() {
        if (INSTANCE == null) {
            log.info("Creating a Lazy database connection");
            INSTANCE = new LazyDatabaseConnection();
        }
        return INSTANCE;
    }

    public void connect() {
        log.info("Connecting database using LazyDatabase connector ");
    }

}
