package com.pioneers.designpatterns.strategy.objectprovider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SenderController {

    private final OrderService orderService;

    public SenderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("message/{message}")
    public void send(@PathVariable String message) {
        orderService.send(message);
    }
}
