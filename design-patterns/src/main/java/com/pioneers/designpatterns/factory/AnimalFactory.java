package com.pioneers.designpatterns.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalFactory {

    public static AnimalService retrieveAnimal(final Animal animal) {
        if (Animal.LION.equals(animal)) {
            return new Lion();
        }

        if (Animal.TIGER.equals(animal)) {
            return new Tiger();
        }

        if (Animal.DOG.equals(animal)) {
            return new Dog();
        }

        throw new Animal.AnimalException("The animal " + animal + " is not a listed in our system");
    }
}
