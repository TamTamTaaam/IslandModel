package services.helper;

import dataAnimals.Animal;
import services.RandomNumberService;

import java.util.List;

public class ChoiceAnimalService {
    private final RandomNumberService randomNumberService;

    public ChoiceAnimalService() {
        this.randomNumberService = new RandomNumberService();
    }

    public Animal choiceAnimal(List<Animal> animals) {
        int randomNumberAnimal = randomNumberService.getRandomNumber(animals.size());
        return animals.get(randomNumberAnimal);
    }
}
