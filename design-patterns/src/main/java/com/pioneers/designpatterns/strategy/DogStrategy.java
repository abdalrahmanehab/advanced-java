package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * A strategy class that implements the methods for the Dog Animal
 *
 * @see com.pioneers.designpatterns.strategy.AnimalService
 * @author abdelaziz.said
 */
@Slf4j
@Repository
public class DogStrategy implements AnimalService {

    private static final Animal DOG = Animal.DOG;

    public DogStrategy() {
        log.debug("DogStrategy bean constructed");
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return DOG.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }
}
