package com.pioneers.designpatterns.strategy;

public interface AnimalService {

    boolean isTypeAligned(Animal type);

    void feed();

    void makeSound();
}
