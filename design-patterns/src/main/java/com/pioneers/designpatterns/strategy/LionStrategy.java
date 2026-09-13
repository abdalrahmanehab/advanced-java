package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
//@Primary
@Order(1)
@Service
public class LionStrategy implements AnimalService {

    private static final Animal LION = Animal.LION;

    public LionStrategy() {
        log.debug("LionStrategy bean constructed");
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return LION.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗");
    }

    @Override
    public void makeSound() {
        log.info("🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁");
    }

    /*@Override
    public int getOrder() {
        return 1;
    }*/
}
