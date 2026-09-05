package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ZebraStrategy implements AnimalService {

    private static final Animal ZEBRA = Animal.ZEBRA;

    public ZebraStrategy() {
        log.debug("ZebraStrategy bean constructed");
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return ZEBRA.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
    }

    @Override
    public void makeSound() {
        log.info("🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓");
    }
}
