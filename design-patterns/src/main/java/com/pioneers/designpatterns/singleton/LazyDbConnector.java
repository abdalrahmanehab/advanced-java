package com.pioneers.designpatterns.singleton;

import com.pioneers.designpatterns.configs.db.ConnectionPool;
import com.pioneers.designpatterns.configs.db.DbConnector;

public class LazyDbConnector {
    private static LazyDbConnector INSTANCE;

    private final DbConnector dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));

    private LazyDbConnector() {
        System.out.println("Initializing LazyDbConnector......");
//        dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));
    }

    public static LazyDbConnector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyDbConnector();
        }
        return INSTANCE;
    }

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
