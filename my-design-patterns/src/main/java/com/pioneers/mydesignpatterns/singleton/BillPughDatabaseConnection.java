package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BillPughDatabaseConnection {

    private BillPughDatabaseConnection() {
        log.info("loading BillPughDatabaseConnection without initializing Connection");
    }


    public static BillPughDatabaseConnection getInstance() {
        return BillPughDatabaseConnectionHolder.INSTANCE;
    }

    public void connect() {
        log.info("connecting using BillPughDatabaseConnection singleton");
    }

    private static class BillPughDatabaseConnectionHolder {
        private static final BillPughDatabaseConnection INSTANCE = new BillPughDatabaseConnection();
    }
}
