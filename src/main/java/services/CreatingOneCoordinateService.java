package services;

import dataAnimals.Animal;
import factory.AnimalFactory;

import java.io.IOException;
import java.util.*;

import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class CreatingOneCoordinateService {

    private final Set<Map.Entry<String, Animal>> SET_ANIMAL;
    private final Map<String, Integer> LIMIT_ANIMAL;
    private final AnimalFactory animalFactory = new AnimalFactory();

    public CreatingOneCoordinateService() throws IOException {
        this.SET_ANIMAL = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        this.LIMIT_ANIMAL = createMapLimitAnimals();
    }

    public List<Animal> creatingListAnimalsInSomeCoordinate(Integer countAnimals) throws IllegalAccessException {
        List<Animal> animalsInOneCoordinate = new ArrayList<>();
        Map<String, Integer> countSomeAnimalInOneCoordinate = new HashMap<>();
        while (animalsInOneCoordinate.size()!=countAnimals){
            Animal addAnimal = animalFactory.createAnimal();
            if(countSomeAnimalInOneCoordinate.containsKey(addAnimal.getNameAnimal())) {
                countSomeAnimalInOneCoordinate.computeIfPresent(addAnimal.getNameAnimal(), (key, value) -> value+1);
                if(countSomeAnimalInOneCoordinate.get(addAnimal.getNameAnimal())< LIMIT_ANIMAL.get(addAnimal.getNameAnimal())) {
                    animalsInOneCoordinate.add(addAnimal);
                }
            } else {
                countSomeAnimalInOneCoordinate.put(addAnimal.getNameAnimal(), 1);
            }
        }
        return animalsInOneCoordinate;
    }

    private Map<String, Integer> createMapLimitAnimals() {
        Map<String, Integer> limitAnimal = new HashMap<>();
        for (Map.Entry<String, Animal> map : SET_ANIMAL) {
           limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
        }
        return limitAnimal;
    }


}
