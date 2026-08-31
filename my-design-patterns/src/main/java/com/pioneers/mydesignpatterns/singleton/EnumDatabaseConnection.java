package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumDatabaseConnection {
    INSTANCE;

    public void connect(){
        log.info("Connecting using EnumDatabaseConnection ");
    }
}
