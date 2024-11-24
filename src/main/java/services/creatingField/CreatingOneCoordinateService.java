package services.creatingField;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import factory.AnimalFactory;
import lombok.SneakyThrows;
import services.RandomNumberService;
import services.helper.CreateMapLimitAnimals;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static services.IslandLibrary.PLANT;


class CreatingOneCoordinateService {

    private final CreateMapLimitAnimals createMapLimitAnimals;
    private final AnimalFactory animalFactory;
    private final RandomNumberService randomNumberService;

    CreatingOneCoordinateService() {
        this.createMapLimitAnimals = new CreateMapLimitAnimals();
        this.animalFactory = new AnimalFactory();
        this.randomNumberService = new RandomNumberService();
    }
    List<IslandObject> creatingListIslandObjectInSomeCoordinate(Integer limitCountAnimalsInOneCoordinate) {
        List<IslandObject> startIslandObjects = new CopyOnWriteArrayList<>();
        startIslandObjects.addAll(creatingListAnimalsInSomeCoordinate(limitCountAnimalsInOneCoordinate));
        startIslandObjects.addAll(creatingListPlantsInSomeCoordinate());
        return startIslandObjects;
    }
    @SneakyThrows
    private List<Animal> creatingListAnimalsInSomeCoordinate(Integer limitCountAnimalsInOneCoordinate)  {
        List<Animal> animalsInOneCoordinate = new ArrayList<>();
        Map<String, Integer> countSomeAnimalInOneCoordinate = new ConcurrentHashMap<>();
        while (animalsInOneCoordinate.size()!=limitCountAnimalsInOneCoordinate){
            Animal newAddAnimal = animalFactory.createAnimalsStart();
            String animalName = newAddAnimal.getNameAnimal();
            int currentCount = countSomeAnimalInOneCoordinate.getOrDefault(animalName, 0);
            int limitCount = createMapLimitAnimals.MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES.get(animalName);
            if (currentCount < limitCount) {
                animalsInOneCoordinate.add(newAddAnimal);
                countSomeAnimalInOneCoordinate.put(animalName, currentCount + 1);
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

}
