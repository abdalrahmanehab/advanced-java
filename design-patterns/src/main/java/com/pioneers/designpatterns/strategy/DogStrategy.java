package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * A strategy class that implements the methods for the Dog Animal
 *
 * @see com.pioneers.designpatterns.strategy.AnimalService
 * @author abdelaziz.said
 */
@Slf4j
@Order(4)
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DogStrategy implements AnimalService {

    private static final Animal DOG = Animal.DOG;

    private final UUID currentUUID = UUID.randomUUID();

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

    /*@Override
    public int getOrder() {
        return 4;
    }*/

    public UUID currentUUID() {
        return currentUUID;
    }
}
