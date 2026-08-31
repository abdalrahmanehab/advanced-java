package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadSafeDatabaseConnection {
    private static ThreadSafeDatabaseConnection INSTANCE;

    private ThreadSafeDatabaseConnection() {
        log.info("compiling the ThreadSafeDatabaseConnection without initializing the INSTANCE");
    }


    public synchronized static ThreadSafeDatabaseConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeDatabaseConnection();
        }
        return INSTANCE;
    }

    public void connect() {
        log.info("Connecting using thread safe database connection");
    }

}
