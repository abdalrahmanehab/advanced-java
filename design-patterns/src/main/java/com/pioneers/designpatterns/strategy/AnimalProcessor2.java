package com.pioneers.designpatterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * AnimalProcessor is a delegator class for Animal Strategies.
 *
 * @author abdelaziz.said
 */
@Slf4j
@Component
public class AnimalProcessor2 {

    private final List<AnimalService> animalServices;

    public AnimalProcessor2(List<AnimalService> animalServices) {
        this.animalServices = animalServices.stream().toList();
    }

    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        final Object[] elements = {"feedAnimal", animal};
        getFirstAnimalService(animalServices, animal)
                .ifPresentOrElse(AnimalService::feed, () -> {
                    log.error("{}, [{}]: animal not found", elements);
                    throw new Animal.AnimalException(String.format("[%s]: animal not found", animal));
                });
    }

    public void makeSound(final Animal animal) throws Animal.AnimalException {
        final Object[] elements = {"feedAnimal", animal.getAnimalType()};
        getFirstAnimalService(animalServices, animal)
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                    log.error("{}, [{}]: type not found", elements);
                    throw new Animal.AnimalException(String.format("[%s]: type not found", animal.getAnimalType()));
                });
    }

    private static Optional<AnimalService> getFirstAnimalService(
            final List<AnimalService> animalServices,
            final Animal animal
    ) {
        return animalServices
                .stream()
                .filter(animalService -> animalService.isTypeAligned(animal))
                .findFirst();
    }
}
