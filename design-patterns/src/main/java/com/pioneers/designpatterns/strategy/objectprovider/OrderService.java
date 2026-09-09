package com.pioneers.designpatterns.strategy.objectprovider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private final ObjectProvider<SenderService> smsSender;
    private final ObjectProvider<SenderService> emailSender;

    public OrderService(
            ObjectProvider<SenderService> smsSender,
            ObjectProvider<SenderService> emailSender
    ) {
        this.smsSender = smsSender;
        this.emailSender = emailSender;
    }

//    private final ObjectProvider<SenderService> senderServices;

    public void send(String message) {
        /*final SmsService smsService = smsServiceProvider.getIfAvailable();
        if (smsService != null) {
            smsService.send(message);
        }*/
//       smsServiceProvider.ifAvailable(smsService1 -> smsService1.send(message));

        /*final SmsService smsService = smsServiceProvider.getIfAvailable();
        if (smsService == null) {
            Email email = new Email();
            email.send(message);
        }*/

        /*senderServices.stream()
                .findFirst()
                .ifPresentOrElse(senderService -> senderService.send(message), () -> {
                    throw new SenderException("SMS and Email could not be sent");
                });*/

        try {
            final SenderService senderService = smsSender.getIfAvailable(
                    () -> emailSender.stream().findFirst().orElseThrow(() -> new EmailException("Email Sender service not found"))
            );

            senderService.send(message);
        } catch (EmailException e) {
            log.error(e.getMessage());
        }
    }
}
