package com.pioneers.designpatterns.factory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "animalControllerFactory")
@RequestMapping("factory/animalService")
public class AnimalController {

    @GetMapping("feed/{animalName}")
    public String feedAnimalApi(@PathVariable String animalName) {

        try {
            final Animal animal = Animal.fromType(animalName);
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animal);
            animalService.feed();

        } catch (Animal.AnimalException e) {
            return e.getMessage();
        }

        return "Successfully feed animal";
    }

    @GetMapping("makeSound/{animalName}")
    public String makeSoundApi(@PathVariable String animalName) {

        try {
            final Animal animal = Animal.fromType(animalName);
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animal);

            animalService.makeSound();
        } catch (Animal.AnimalException e) {
            return e.getMessage();
        }

        return "Successfully made animal sound";
    }
}
