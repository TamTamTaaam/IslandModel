package services;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import island.Coordinate;
import island.IslandParameters;
import dataAnimals.Animal;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CreatingIslandService {
    public ConcurrentHashMap<Coordinate, List<IslandObject>> ISLAND;
    private final IslandParameters islandParameters;
    private final int countCoordinates;
    private final Map<Coordinate, Integer> countAnimalsInSomeCoordinate;
    private final CreatingOneCoordinateService creatingOneCoordinateService = new CreatingOneCoordinateService();


    @SneakyThrows
    public CreatingIslandService() throws IOException {
        this.islandParameters = new ReadFileService().readCoordinates();
        this.countCoordinates = islandParameters.getCoordinateX()* islandParameters.getCoordinateY();
        this.countAnimalsInSomeCoordinate = creatingMapWithCountAnimalsInSomeCoordinate();
        this.ISLAND = creatingWorld();
    }

    private ConcurrentHashMap<Coordinate, List<IslandObject>> creatingWorld() throws IllegalAccessException {
        ConcurrentHashMap<Coordinate, List<IslandObject>> island = new ConcurrentHashMap<>();
        Set<Map.Entry<Coordinate, Integer>> entries = countAnimalsInSomeCoordinate.entrySet();
        for (Map.Entry<Coordinate, Integer> map : entries) {
            List<Animal> animals = creatingOneCoordinateService.creatingListAnimalsInSomeCoordinate(map.getValue());
            List<Plant> plants = creatingOneCoordinateService.creatingListPlantsInSomeCoordinate();
            List<IslandObject> islandObjects = new ArrayList<>();
            islandObjects.addAll(animals);
            islandObjects.addAll(plants);
            island.putIfAbsent(map.getKey(), islandObjects);
        }
        return island;
    }

    private Map<Coordinate, Integer> creatingMapWithCountAnimalsInSomeCoordinate() {
        Map<Coordinate, Integer> countAnimalsInSomeCoordinate = new HashMap<>();
        int countAnimals =  islandParameters.getCountAnimals() / countCoordinates;
        if(getStepCoordinateWithCountAnimalsMoreThanRest()==0) {
            for (int i = 1; i <= islandParameters.getCoordinateX(); i++) {
                for (int j = 1; j <= islandParameters.getCoordinateY(); j++) {
                    countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                }
            }
        } else {
            int numberCoordinate = 0;
            for (int i = 1; i <= islandParameters.getCoordinateX(); i++) {
                for (int j = 1; j <= islandParameters.getCoordinateY(); j++) {
                    if(((numberCoordinate+1)%getStepCoordinateWithCountAnimalsMoreThanRest())!=0) {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                    } else {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals+1);
                    }
                    numberCoordinate++;
                }
            }
        }
        return countAnimalsInSomeCoordinate;
    }

    private int getStepCoordinateWithCountAnimalsMoreThanRest() {
        double countAnimalsInOneCoordinate = (double) islandParameters.getCountAnimals() / countCoordinates;
        int countCelAnimalsInOneCoordinate = (int) countAnimalsInOneCoordinate;
        double fractionalPart = countAnimalsInOneCoordinate - countCelAnimalsInOneCoordinate;
        if (fractionalPart!=0) {
            return (int) Math.round(1 / fractionalPart);
        } else {
            return 0;
        }
    }
}
