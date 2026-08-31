package com.pioneers.mydesignpatterns.singleton;

public class DatabaseConnectionMain {
    public static void main(String[] args) {
        EagerDatabaseConnection db1 = EagerDatabaseConnection.getInstance();
        db1.connect();

        //connecting lazy first time
        LazyDatabaseConnection db2 = LazyDatabaseConnection.getInstance();
        db2.connect();

        //connecting lazy second time
        LazyDatabaseConnection db3 = LazyDatabaseConnection.getInstance();
        db3.connect();
    }
}
