package com.pioneers.designpatterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AnimalProcessor4 {

    private final ApplicationContext applicationContext;

    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        applicationContext.getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst()
                .ifPresentOrElse(AnimalService::feed, () -> {
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

    public void makeSound(final Animal animal) throws Animal.AnimalException {
        applicationContext.getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst()
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

}
