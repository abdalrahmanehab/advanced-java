package com.pioneers.designpatterns.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Animal {
    LION("lion"),
    DOG("dog"),
    TIGER("tiger"),
    CAT("cat"),
    ZEBRA("zebra");

    private final String animalType;

    public static Animal fromType(final String animalType) throws AnimalException {
        return Arrays.stream(Animal.values())
                .filter(animal -> animal.hasType(animalType))
                .findFirst()
                .orElseThrow(() -> new AnimalException(animalType + " is not listed in our system"));
    }

    private boolean hasType(final String animalType) {
        return this.getAnimalType().equalsIgnoreCase(animalType);
    }

    public boolean hasType(final Animal animal) {
        return this.getAnimalType().equalsIgnoreCase(animal.getAnimalType());
    }

    public static class AnimalException extends RuntimeException {
        public AnimalException(String message) {
            super(message);
        }
    }
}
