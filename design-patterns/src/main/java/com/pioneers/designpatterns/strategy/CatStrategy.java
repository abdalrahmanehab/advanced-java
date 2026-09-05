package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * A strategy class that implements the methods for the Cat Animal
 *
 * @see AnimalService
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class CatStrategy implements AnimalService {

    // TODO: Change the type to be beanName
    private static final Animal CAT = Animal.CAT;

    public CatStrategy() {
        log.debug("CatStrategy bean constructed");
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return CAT.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }
}
