package com.pioneers.rest.configs.singleton;

import com.pioneers.rest.configs.db.ConnectionPool;
import com.pioneers.rest.configs.db.DbConnector;

public enum EnumDbConnector {
    INSTANCE;

    private final DbConnector dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));

    public void insert() {
        System.out.println("Inserting object to Db.....");
    }

    public void delete() {
        System.out.println("Deleting Object from table.....");
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
