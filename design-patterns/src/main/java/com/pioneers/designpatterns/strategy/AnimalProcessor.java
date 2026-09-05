package com.pioneers.designpatterns.strategy;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class AnimalProcessor {

    private final AnimalService animalService;
    private final AnimalService dogAnimalService;

    @Autowired
    public AnimalProcessor(@Qualifier("tigerStrategyBean") AnimalService animalService, @Qualifier("dogStrategy") AnimalService dogService) {
        this.animalService = animalService;
        this.dogAnimalService = dogService;
    }

    public void feedAnimal() {
        animalService.feed();
    }

    public void makeSound() {
        animalService.makeSound();
    }

    public void feedDog () {
        dogAnimalService.feed();
    }
}
