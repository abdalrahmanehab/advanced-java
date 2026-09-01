package com.pioneers.mydesignpatterns.factory;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Payment {
    CreditCard("credit_card"),
    PayPal("paypal"),
    Crypto("crypto"),
    VodafoneCash("vodafone_cash");

    private final String paymentType;

    Payment(String paymentType) {
        this.paymentType = paymentType;
    }

    public static Payment formType(String paymentType) {
        return Arrays.stream(Payment.values())
                .filter(payment -> payment.hasType(paymentType))
                .findFirst()
                .orElseThrow(() -> new PaymentException(paymentType + " is not supported!"));

    }


    private boolean hasType(String paymentType) {
        return (this.getPaymentType().equalsIgnoreCase(paymentType));
    }


    private static class PaymentException extends RuntimeException {
        public PaymentException(String message) {
            super(message);
        }
    }


}
