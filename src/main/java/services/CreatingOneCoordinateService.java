package services;

import dataAnimals.Animal;
import dataAnimals.AnimalLibrary;

import java.util.Map;
import java.util.Set;

import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class CreatingOneCoordinateService {

    private final int maxCountAnimalsInOneCoordinate;

    public CreatingOneCoordinateService(int maxCountAnimalsInOneCoordinate) {
        this.maxCountAnimalsInOneCoordinate = maxCountAnimalsInOneCoordinate;
    }

    private int getMaxCountAnimalsInOneCoordinate() {
        Set<Map.Entry<String, Animal>> entries = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        int maxCountAnimals = 0;
        for (Map.Entry<String, Animal> map : entries) {
            int countAnimal = map.getValue().getMaxAmount();
            if(countAnimal>maxCountAnimals) {
                maxCountAnimals = countAnimal;
            }
        }
        return maxCountAnimals;
    }

    public void crestingListAnimalsInSomeCoordinate() {

    }
}
