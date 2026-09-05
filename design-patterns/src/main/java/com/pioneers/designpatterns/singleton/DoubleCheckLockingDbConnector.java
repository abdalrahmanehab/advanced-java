package com.pioneers.designpatterns.singleton;

import com.pioneers.designpatterns.configs.db.ConnectionPool;
import com.pioneers.designpatterns.configs.db.DbConnector;

public class DoubleCheckLockingDbConnector {
    private static DoubleCheckLockingDbConnector INSTANCE;

    private final DbConnector dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));

    private DoubleCheckLockingDbConnector() {
        System.out.println("Initializing LazyDbConnector......");
    }

    public static DoubleCheckLockingDbConnector getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockingDbConnector.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockingDbConnector();
                }
            }
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
