package com.pioneers.mydesignpatterns.factory;

public class PaymentFactory {

    public static PaymentService getPaymentService(Payment payment) {
        return switch (payment) {
            case Crypto -> new CryptoPayment();
            case PayPal -> new PayPalPayment();
            case CreditCard -> new CreditCardPayment();
        };
    }

}
