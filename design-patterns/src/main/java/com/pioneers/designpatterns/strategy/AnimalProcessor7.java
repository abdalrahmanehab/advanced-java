package com.pioneers.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * AnimalProcessor is a delegator class for Animal Strategies and cache strategies on map using bean name
 *
 * @author abdalrahman.ehab
 */

@Slf4j
@Component
public class AnimalProcessor7 {
    private final Map<String, AnimalService> animalServices;

    @Autowired
    public AnimalProcessor7(Map<String, AnimalService> animalServices) {
        this.animalServices = animalServices;

//        Arrays.stream(Animal.values())
//                .filter(animal -> !animalServices.containsKey(animal.getAnimalType()))
//                .findFirst()
//                .ifPresent(animal -> {
//                    log.info("{} has not been implemented as strategy or forgot to change been name", animal.getAnimalType());
//                    throw new Animal.AnimalException
//                            (animal.getAnimalType() + " has not been implemented as strategy or forgot to change been name");
//                });

        List<Animal> missingAnimals = Arrays.stream(Animal.values())
                .filter(animal -> !animalServices.containsKey(animal.getAnimalType()))
                .toList();

        if (!missingAnimals.isEmpty()) {
            log.error("Missing strategy implementation or modifying bean name for {} ", missingAnimals);
            throw new Animal.AnimalException("Missing strategy implementation or modifying bean name for " + missingAnimals);
        }
    }


    public void feedAnimal(final Animal animal) throws Animal.AnimalException {
        animalServices.get(animal.getAnimalType())
                .feed();
    }

}
