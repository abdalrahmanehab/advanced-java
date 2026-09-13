package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class AnimalProcessor6 {

    private final ObjectProvider<AnimalService> animalServiceProvider;

    @Autowired
    public AnimalProcessor6(@Qualifier("dogStrategy") ObjectProvider<AnimalService> animalServiceProvider) {
        this.animalServiceProvider = animalServiceProvider;
    }

    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        animalServiceProvider.getObject().feed();

        log.debug("Object UUID: [{}]", ((DogStrategy) animalServiceProvider.getObject()).currentUUID());
    }

    public void makeSound(final Animal animal) throws Animal.AnimalException {
        animalServiceProvider.getObject().makeSound();
    }
}
