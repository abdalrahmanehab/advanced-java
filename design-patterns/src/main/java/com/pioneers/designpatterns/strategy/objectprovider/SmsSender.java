package com.pioneers.designpatterns.strategy.objectprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class SmsSender implements SenderService {
    /*@Override
    public int order() {
        return 1;
    }*/

    @Override
    public void send(String message) {
        log.info("Sending message: [{}] via SMS", message);
    }
}
