package com.pioneers.rest.utils.scopes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

//@Lazy
@Slf4j
@RestController
@RequestMapping("scope")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class ScopeController {

    private final WelcomeProcessor welcomeProcessor;

    public ScopeController(WelcomeProcessor welcomeProcessor) {
        this.welcomeProcessor = welcomeProcessor;
        log.debug("Injected the Welcome Processor into the ScopeController");
    }

    @GetMapping("welcome")
    public UUID getBeanUuid() {
        return welcomeProcessor.getCurrentUuid();
    }
}
