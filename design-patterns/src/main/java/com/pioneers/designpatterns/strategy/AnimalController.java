package com.pioneers.designpatterns.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("animalControllerStrategy")
@RequestMapping("strategy/animalService")
public class AnimalController {

    private final AnimalProcessor4 animalProcessor;

    @GetMapping("feed/{animalType}")
    public String feedAnimalApi(@PathVariable String animalType) {

        try {
            final Animal animal = Animal.fromType(animalType);

            animalProcessor.feedAnimal(animal);

        } catch (Animal.AnimalException e) {
            return e.getMessage();
        }

        return "Successfully feed animal";
    }

    @GetMapping("makeSound/{animalType}")
    public String makeSoundApi(@PathVariable String animalType) {

        try {
            final Animal animal = Animal.fromType(animalType);

            animalProcessor.makeSound(animal);
        } catch (Animal.AnimalException e) {
            return e.getMessage();
        }

        return "Successfully made animal sound";
    }
}
