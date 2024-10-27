package services;

import dataAnimals.Animal;

import java.util.*;

import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class CreatingOneCoordinateService {

    private final Set<Map.Entry<String, Animal>> SET_ANIMAL;
    private final Map<String, Integer> LIMIT_ANIMAL;

    public CreatingOneCoordinateService() {
        this.SET_ANIMAL = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        this.LIMIT_ANIMAL = createMapLimitAnimals();
    }

    public void crestingListAnimalsInSomeCoordinate() {
        List<Animal> animalsInOneCoordinate = new ArrayList<>();


    }

    private Map<String, Integer> createMapLimitAnimals() {
        Map<String, Integer> limitAnimal = new HashMap<>();
        for (Map.Entry<String, Animal> map : SET_ANIMAL) {
           limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
        }
        return limitAnimal;
    }
}
