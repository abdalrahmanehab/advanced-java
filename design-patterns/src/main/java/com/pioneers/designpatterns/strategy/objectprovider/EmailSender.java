package com.pioneers.designpatterns.strategy.objectprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(2)
public class EmailSender implements SenderService{

    /*@Override
    public int order() {
        return 2;
    }*/

    @Override
    public void send(String message) {
        log.info("Sending email [{}]", message);
    }
}
