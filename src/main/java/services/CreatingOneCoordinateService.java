package services;

import dataAnimals.Animal;
import dataAnimals.Plant;
import factory.AnimalFactory;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.*;

import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static dataAnimals.AnimalLibrary.PLANT;

public class CreatingOneCoordinateService {

    private final Set<Map.Entry<String, Animal>> setAnimal;
    private final Map<String, Integer> limitAnimal;
    private final AnimalFactory animalFactory = new AnimalFactory();
    private final RandomNumberService randomNumberService;

    public CreatingOneCoordinateService() throws IOException {
        this.setAnimal = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        this.limitAnimal = createMapLimitAnimals();
        this.randomNumberService = new RandomNumberService();
    }

    @SneakyThrows
    public List<Animal> creatingListAnimalsInSomeCoordinate(Integer countAnimals)  {
        List<Animal> animalsInOneCoordinate = new ArrayList<>();
        Map<String, Integer> countSomeAnimalInOneCoordinate = new HashMap<>();
        while (animalsInOneCoordinate.size()!=countAnimals){
            Animal addAnimal = animalFactory.createAnimal();
            if(countSomeAnimalInOneCoordinate.containsKey(addAnimal.getNameAnimal())) {
                countSomeAnimalInOneCoordinate.computeIfPresent(addAnimal.getNameAnimal(), (key, value) -> value+1);
                if(countSomeAnimalInOneCoordinate.get(addAnimal.getNameAnimal())< limitAnimal.get(addAnimal.getNameAnimal())) {
                    animalsInOneCoordinate.add(addAnimal);
                }
            } else {
                countSomeAnimalInOneCoordinate.put(addAnimal.getNameAnimal(), 1);
            }
        }
        return animalsInOneCoordinate;
    }
    List<Plant> creatingListPlantsInSomeCoordinate() {
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < randomNumberService.getRandomNumber(PLANT.getMaxAmount()+1); i++) {
            plants.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
        }
        return plants;
    }

    private Map<String, Integer> createMapLimitAnimals() {
        Map<String, Integer> limitAnimal = new HashMap<>();
        for (Map.Entry<String, Animal> map : setAnimal) {
           limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
        }
        return limitAnimal;
    }


}
