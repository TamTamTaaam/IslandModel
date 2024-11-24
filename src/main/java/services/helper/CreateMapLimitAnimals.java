package services.helper;

import dataAnimals.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class CreateMapLimitAnimals {
    private final Set<Map.Entry<String, Animal>> SET_ANIMAL;
    public final Map<String, Integer> MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES;

    public CreateMapLimitAnimals() {
        this.SET_ANIMAL = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        this.MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES = createMapLimitAnimals();
    }

    private Map<String, Integer> createMapLimitAnimals() {
        Map<String, Integer> limitAnimal = new HashMap<>();
        for (Map.Entry<String, Animal> map : SET_ANIMAL) {
            limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
        }
        return limitAnimal;
    }
}
