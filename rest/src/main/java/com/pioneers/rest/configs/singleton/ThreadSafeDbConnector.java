package com.pioneers.rest.configs.singleton;

import com.pioneers.rest.configs.db.ConnectionPool;
import com.pioneers.rest.configs.db.DbConnector;

public class ThreadSafeDbConnector {
    private static ThreadSafeDbConnector INSTANCE;

    private final DbConnector dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));

    private ThreadSafeDbConnector() {
        System.out.println("Initializing LazyDbConnector......");
//        dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));
    }

    public static synchronized ThreadSafeDbConnector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeDbConnector();
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
