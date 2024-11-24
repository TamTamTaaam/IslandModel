package services.helper;

import dataAnimals.Animal;
import dataAnimals.IslandObject;

import java.util.ArrayList;
import java.util.List;

public class SelectionOnlyAnimalsService {
    public List<Animal> selectionAnimals(List<IslandObject> islandObjects) {
        List<Animal> animals = new ArrayList<>();
        for (IslandObject islandObject : islandObjects) {
            if (islandObject instanceof Animal animal) {
                animals.add(animal);
            }
        }
        return animals;
    }
}
