package services.incessant;

import dataAnimals.Animal;
import dataAnimals.IslandObject;

import java.util.List;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class StarvationService {
    private final double percentageDecreaseSatiety = 0.15;

    public void starvation(List<IslandObject> island) {
        for (IslandObject islandObject : island) {
            if (islandObject instanceof Animal animal) {
                if (animal.getMaxSatiety() > 0) {
                    double nowSatiety = animal.getMaxSatiety();
                    double actualSatiety = nowSatiety - (MAP_ALL_ANIMALS_IN_PROGRAM.get(animal.getNameAnimal()).getMaxSatiety() * percentageDecreaseSatiety);
                    animal.setMaxSatiety(actualSatiety);
                } else {
                    island.remove(animal);
                }
            }
        }
    }
}
