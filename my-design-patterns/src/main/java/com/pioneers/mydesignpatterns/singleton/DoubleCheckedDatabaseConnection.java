package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleCheckedDatabaseConnection {
    private static DoubleCheckedDatabaseConnection INSTANCE;

    private DoubleCheckedDatabaseConnection() {
        log.info("compiling the DoubleCheckedDatabaseConnection without initializing the INSTANCE");
    }


    public static DoubleCheckedDatabaseConnection getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedDatabaseConnection.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedDatabaseConnection();
                }
            }
        }
        return INSTANCE;
    }

    public void connect() {
        log.info("connecting using double checked database connection");
    }


}
