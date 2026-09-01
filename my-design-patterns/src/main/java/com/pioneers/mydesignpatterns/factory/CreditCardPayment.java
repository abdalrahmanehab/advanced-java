package com.pioneers.mydesignpatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditCardPayment implements PaymentService {

    @Override
    public void processPayment() {
        log.info("processing CreditCardPayment");
    }
}
