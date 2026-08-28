package com.pioneers.rest.controllers;

import com.pioneers.rest.configs.db.DbConnector;
import com.pioneers.rest.configs.singleton.EnumDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("controller1")
public class BeanInjection1Controller {

    private final DbConnector dbConnector;

    @Autowired
    public BeanInjection1Controller(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @GetMapping("dbConnector")
    public DbConnector getDbConnectorApi() {
        return dbConnector;
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        this.dbConnector.setUsername(dbConnector.getUsername());
        this.dbConnector.setPassword(dbConnector.getPassword());
        this.dbConnector.setDatabase(dbConnector.getDatabase());
        this.dbConnector.setUrl(dbConnector.getUrl());
        this.dbConnector.setConnectionPool(dbConnector.getConnectionPool());
    }


    @PostMapping("save")
    public void saveDbConnectorApi(@RequestBody DbConnector dbConnector) {
        EnumDbConnector.INSTANCE.insert();
    }
}
