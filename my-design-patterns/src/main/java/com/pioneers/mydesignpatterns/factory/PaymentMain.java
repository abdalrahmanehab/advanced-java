package com.pioneers.mydesignpatterns.factory;

public class PaymentMain {
    public static void main(String[] args) {
        String paymentInput1 = "PayPal";
        String paymentInput2 = "vodafone_cash";

        Payment payment = Payment.formType(paymentInput1);
        PaymentService paymentService = PaymentFactory.getPaymentService(payment);
        paymentService.processPayment();

        Payment payment2 = Payment.formType(paymentInput2);
        PaymentService paymentService2 = PaymentFactory.getPaymentService(payment2);
        paymentService2.processPayment();

    }
}
