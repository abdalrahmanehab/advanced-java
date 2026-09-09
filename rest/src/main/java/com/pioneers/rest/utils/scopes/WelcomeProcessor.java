package com.pioneers.rest.utils.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

//@Lazy
@Slf4j
@Component
//@Scope("singleton")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class WelcomeProcessor {

    private final UUID currentUuid = UUID.randomUUID();

    public WelcomeProcessor() {
        log.debug("Created the WelcomeProcessor bean!!");
    }

    public UUID getCurrentUuid() {
        return currentUuid;
    }
}
