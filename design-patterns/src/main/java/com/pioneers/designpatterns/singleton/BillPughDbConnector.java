package com.pioneers.designpatterns.singleton;

import com.pioneers.designpatterns.configs.db.ConnectionPool;
import com.pioneers.designpatterns.configs.db.DbConnector;

public class BillPughDbConnector {

    private final DbConnector dbConnector;

    private BillPughDbConnector() {
        System.out.println("Initializing LazyDbConnector......");
        dbConnector = new DbConnector("", "", "", "", new ConnectionPool(0, 0, 0));
    }

    public static class DbConnectorHolder {
        public static final BillPughDbConnector INSTANCE = new BillPughDbConnector();
    }

    public static BillPughDbConnector getInstance() {
        return DbConnectorHolder.INSTANCE;
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
