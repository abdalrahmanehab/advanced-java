package com.pioneers.mydesignpatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayPalPayment implements PaymentService {

    @Override
    public void processPayment() {
        log.info("processing PayPalPayment");

    }
}
