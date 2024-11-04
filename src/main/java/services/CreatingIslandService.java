package services;
import island.Coordinate;
import island.IslandParameters;
import dataAnimals.Animal;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CreatingIslandService {
    public ConcurrentHashMap<Coordinate, List<Animal>> ISLAND;
    private final IslandParameters ISLAND_PARAMETERS;
    private final int COUNT_COORDINATES;
    private final Map<Coordinate, Integer> countAnimalsInSomeCoordinate;
    private final CreatingOneCoordinateService creatingOneCoordinateService = new CreatingOneCoordinateService();


    @SneakyThrows
    public CreatingIslandService() throws IOException {
        this.ISLAND_PARAMETERS = new ReadFileService().getCoordinates();
        this.COUNT_COORDINATES = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
        this.countAnimalsInSomeCoordinate = creatingMapWithCountAnimalsInSomeCoordinate();
        this.ISLAND = creatingWorld();
    }

    public ConcurrentHashMap<Coordinate, List<Animal>> creatingWorld() throws IllegalAccessException {
        ConcurrentHashMap<Coordinate, List<Animal>> island = new ConcurrentHashMap<>();
        Set<Map.Entry<Coordinate, Integer>> entries = countAnimalsInSomeCoordinate.entrySet();
        for (Map.Entry<Coordinate, Integer> map : entries) {
            List<Animal> animals = creatingOneCoordinateService.creatingListAnimalsInSomeCoordinate(map.getValue());
            island.putIfAbsent(map.getKey(), animals);
        }
        return island;
    }

    public Map<Coordinate, Integer> creatingMapWithCountAnimalsInSomeCoordinate() {
        Map<Coordinate, Integer> countAnimalsInSomeCoordinate = new HashMap<>();
        int countAnimals =  ISLAND_PARAMETERS.getCountAnimals() / COUNT_COORDINATES; //133
        if(getStepCoordinateWithCountAnimalsMoreThanRest()==0) {                        //3
            for (int i = 1; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 1; j <= ISLAND_PARAMETERS.getCoordinateY(); j++) {
                    countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                }
            }
        } else {
            int numberCoordinate = 0;
            for (int i = 1; i <=ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 1; j <=ISLAND_PARAMETERS.getCoordinateY(); j++) {
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
        double countAnimalsInOneCoordinate = (double) ISLAND_PARAMETERS.getCountAnimals() / COUNT_COORDINATES;
        int countCelAnimalsInOneCoordinate = (int) countAnimalsInOneCoordinate;
        double fractionalPart = countAnimalsInOneCoordinate - countCelAnimalsInOneCoordinate;
        if (fractionalPart!=0) {
            return (int) Math.round(1 / fractionalPart);
        } else {
            return 0;
        }
    }
}
