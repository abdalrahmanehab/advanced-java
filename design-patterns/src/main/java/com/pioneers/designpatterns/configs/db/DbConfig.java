package com.pioneers.designpatterns.configs.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class DbConfig {

    private final DbProperties dbProperties;

    @Autowired
    public DbConfig(DbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Bean
    public DbConnector dbConnector() {
        log.debug("Creating the DB connector bean!!");
        final ConnectionPool connectionPool = toConnectionPool(dbProperties.getConnectionPoolProperties());

        return new DbConnector(
                dbProperties.getUsername(),
                dbProperties.getPassword(),
                dbProperties.getDatabase(),
                dbProperties.getUrl(),
                connectionPool
        );
    }

    private static ConnectionPool toConnectionPool(
            final DbProperties.ConnectionPoolProperties connectionPoolProperties
    ) {
        return new ConnectionPool(
                connectionPoolProperties.getMaxOpenConnections(),
                connectionPoolProperties.getMaxIdleConnections(),
                connectionPoolProperties.getTimeout()
        );
    }
}
