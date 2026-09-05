package com.pioneers.designpatterns.configs.db;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class DbConnector {
    public static final String CLASS_NAME = DbConnector.class.getSimpleName();

    private String username;
    private String password;
    private String database;
    private String url;
    private ConnectionPool connectionPool;

    public DbConnector(String username, String password, String database, String url, ConnectionPool connectionPool) {
        this.username = username;
        this.password = password;
        this.database = database;
        this.url = url;
        this.connectionPool = connectionPool;
        connect(username, password, database, url, connectionPool);
    }

    public void connect(
            final String username,
            final String password,
            final String database,
            final String url,
            final ConnectionPool connectionPool
    ) {
        final String methodName = CLASS_NAME + "/connect";
        Object[] args = {methodName, username, database, url};
        log.debug("{}, Connecting to database [{}] with username [{}] and url [{}]", args);

        args = new Object[]{methodName, database, url};
        log.debug("{}, Successfully connected to database [{}] with url [{}]", args);
    }
}
