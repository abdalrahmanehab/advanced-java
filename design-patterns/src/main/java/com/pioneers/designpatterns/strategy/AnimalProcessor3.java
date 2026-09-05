package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class AnimalProcessor3 {

    private final Map<Animal, AnimalService> animalServices;

    @Autowired
    public AnimalProcessor3(Set<AnimalService> animalServices) {
        this.animalServices = Arrays.stream(Animal.values())
                .collect(Collectors.toUnmodifiableMap(
                        animal -> animal,
                        animal -> getFirstAnimalService(animalServices, animal)
                                .orElseThrow(() -> new IllegalStateException(
                                        "No AnimalService found for animal type: " + animal
                                ))
                ));
        System.out.println();
    }

    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        final Object[] elements = {"feedAnimal", animal};
        getAnimalService(animalServices, animal)
                .ifPresentOrElse(AnimalService::feed, () -> {
                    log.error("{}, [{}]: animal not found", elements);
                    throw new Animal.AnimalException(String.format("[%s]: animal not found", animal));
                });
    }

    public void makeSound(final Animal animal) throws Animal.AnimalException {
        final Object[] elements = {"feedAnimal", animal.getAnimalType()};
        getAnimalService(animalServices, animal)
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                    log.error("{}, [{}]: type not found", elements);
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

    private static Optional<AnimalService> getAnimalService(
            final Map<Animal, AnimalService> animalServices,
            final Animal animal
    ) {
        return Optional.ofNullable(animalServices.get(animal));
    }

    private static Optional<AnimalService> getFirstAnimalService(
            final Set<AnimalService> animalServices,
            final Animal animal
    ) {
        return animalServices
                .stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst();
    }
}
