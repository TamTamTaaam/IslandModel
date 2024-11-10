package services;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import factory.AnimalFactory;
import lombok.SneakyThrows;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static dataAnimals.AnimalLibrary.PLANT;

public class CreatingOneCoordinateService {

    private final Set<Map.Entry<String, Animal>> SET_ANIMAL;
    private final Map<String, Integer> MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES;
    private final AnimalFactory animalFactory;
    private final RandomNumberService randomNumberService;

    public CreatingOneCoordinateService() {
        this.SET_ANIMAL = MAP_ALL_ANIMALS_IN_PROGRAM.entrySet();
        this.MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES = createMapLimitAnimals();
        this.animalFactory = new AnimalFactory();
        this.randomNumberService = new RandomNumberService();
    }
    List<IslandObject> creatingListIslandObjectInSomeCoordinate(Integer limitCountAnimalsInOneCoordinate) {
        List<IslandObject> startIslandObjects = new ArrayList<>();
        startIslandObjects.addAll(creatingListAnimalsInSomeCoordinate(limitCountAnimalsInOneCoordinate));
        startIslandObjects.addAll(creatingListPlantsInSomeCoordinate());
        return startIslandObjects;
    }
    @SneakyThrows
    private List<Animal> creatingListAnimalsInSomeCoordinate(Integer limitCountAnimalsInOneCoordinate)  {
        List<Animal> animalsInOneCoordinate = new ArrayList<>();
        Map<String, Integer> countSomeAnimalInOneCoordinate = new ConcurrentHashMap<>();
        while (animalsInOneCoordinate.size()!=limitCountAnimalsInOneCoordinate){
            Animal newAddAnimal = animalFactory.createAnimal();
            if(countSomeAnimalInOneCoordinate.containsKey(newAddAnimal.getNameAnimal())) {
                countSomeAnimalInOneCoordinate.computeIfPresent(newAddAnimal.getNameAnimal(), (key, value) -> value+1);
                if(countSomeAnimalInOneCoordinate.get(newAddAnimal.getNameAnimal())< MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES.get(newAddAnimal.getNameAnimal())) {
                    animalsInOneCoordinate.add(newAddAnimal);
                }
            } else {
                countSomeAnimalInOneCoordinate.put(newAddAnimal.getNameAnimal(), 1);
            }
        }
        return animalsInOneCoordinate;
    }

    private List<Plant> creatingListPlantsInSomeCoordinate() {
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < randomNumberService.getRandomNumber(PLANT.getMaxAmount()+1); i++) {
            plants.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
        }
        return plants;
    }

    private Map<String, Integer> createMapLimitAnimals() {
        Map<String, Integer> limitAnimal = new HashMap<>();
        for (Map.Entry<String, Animal> map : SET_ANIMAL) {
           limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
        }
        return limitAnimal;
    }
}
