package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class AnimalProcessor5 {

    private final List<AnimalService> animalServices;

    public AnimalProcessor5(ApplicationContext applicationContext) {
        animalServices = applicationContext.getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .toList();
    }

    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        animalServices.stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst()
                .ifPresentOrElse(AnimalService::feed, () -> {
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

    public void makeSound(final Animal animal) throws Animal.AnimalException {
        animalServices.stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst()
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

}
