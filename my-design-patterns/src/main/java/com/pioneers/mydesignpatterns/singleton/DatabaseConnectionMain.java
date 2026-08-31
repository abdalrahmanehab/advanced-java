package com.pioneers.mydesignpatterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseConnectionMain {
    public static void main(String[] args) {
        EagerDatabaseConnection eager1 = EagerDatabaseConnection.getInstance();
        EagerDatabaseConnection eager2 = EagerDatabaseConnection.getInstance();
        log.info("Eager Same Instance: {}", (eager1 == eager2));
        eager1.connect();

        LazyDatabaseConnection lazy1 = LazyDatabaseConnection.getInstance();
        LazyDatabaseConnection lazy2 = LazyDatabaseConnection.getInstance();
        log.info("Lazy Same Instance: {}", (lazy1 == lazy2));

        ThreadSafeDatabaseConnection ts1 = ThreadSafeDatabaseConnection.getInstance();
        ThreadSafeDatabaseConnection ts2 = ThreadSafeDatabaseConnection.getInstance();
        log.info("ThreadSafe Same Instance: {}", (ts1 == ts2));

        DoubleCheckedDatabaseConnection dc1 = DoubleCheckedDatabaseConnection.getInstance();
        DoubleCheckedDatabaseConnection dc2 = DoubleCheckedDatabaseConnection.getInstance();
        log.info("DoubleChecked Same Instance: {}", (dc1 == dc2));

        BillPughDatabaseConnection bp1 = BillPughDatabaseConnection.getInstance();
        BillPughDatabaseConnection bp2 = BillPughDatabaseConnection.getInstance();
        log.info("BillPugh Same Instance: {}", (bp1 == bp2));

        EnumDatabaseConnection enum1 = EnumDatabaseConnection.INSTANCE;
        EnumDatabaseConnection enum2 = EnumDatabaseConnection.INSTANCE;
        log.info("Enum Same Instance: {}", (enum1 == enum2));
        enum1.connect();
    }
}