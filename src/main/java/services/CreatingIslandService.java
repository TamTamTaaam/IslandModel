package services;

import island.Coordinate;
import island.IslandParameters;
import dataAnimals.Animal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CreatingIslandService {
    public ConcurrentHashMap<Coordinate, List<Animal>> ISLAND;
    private final IslandParameters ISLAND_PARAMETERS;
    private final Map<Coordinate, Integer> countAnimalsInSomeCoordinates;

    public CreatingIslandService() {
        this.ISLAND_PARAMETERS = new ReadFileService().getCoordinates();
        this.countAnimalsInSomeCoordinates = creatingMapWithCountAnimalInCoordinates();
    }


    public void creatingWorld() {
        Set<Map.Entry<Coordinate, Integer>> entries = countAnimalsInSomeCoordinates.entrySet();
        for (Map.Entry<Coordinate, Integer> map : entries) {
            List<Animal> animals = new ArrayList<>(); // !!!!!!!!
            ISLAND.putIfAbsent(map.getKey(), animals);
        }
    }

    private Map<Coordinate, Integer> creatingMapWithCountAnimalInCoordinates() {
        Map<Coordinate, Integer> countAnimalsInSomeCoordinates = new HashMap<>();
        int countCoordinates = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
        int countAnimals =  ISLAND_PARAMETERS.getCountAnimals() /countCoordinates;
        if(getStep()==0) {
            for (int i = 0; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 0; j <= ISLAND_PARAMETERS.getCoordinateY(); j++) {
                    countAnimalsInSomeCoordinates.put(new Coordinate(i, j), countAnimals);
                }
            }
        } else {
            int step = getStep();
            int addCountAnimals = 0;
            for (int i = 0; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 0; j <= ISLAND_PARAMETERS.getCoordinateY()-1; j++) {
                    int k = 1;
                    if((k%step)==0) {
                        countAnimalsInSomeCoordinates.put(new Coordinate(i, j), countAnimals);
                        addCountAnimals = addCountAnimals+countAnimals;
                    } else {
                        countAnimalsInSomeCoordinates.put(new Coordinate(i, j), countAnimals+1);
                        addCountAnimals = addCountAnimals+countAnimals+1;
                    }
                    k++;
                }
            }
            int remainingAnimals = ISLAND_PARAMETERS.getCountAnimals()-addCountAnimals;
            countAnimalsInSomeCoordinates.put(new Coordinate(ISLAND_PARAMETERS.getCoordinateX(), ISLAND_PARAMETERS.getCoordinateY()), remainingAnimals);
        }
        return countAnimalsInSomeCoordinates;
    }

    private int getStep() {
        int countCoordinates = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
        double countAnimals = (double) ISLAND_PARAMETERS.getCountAnimals() / (countCoordinates);
        int countCelAnimals = (int) countAnimals;
        double fractionalPart = countAnimals - countCelAnimals;
        if (fractionalPart!=0) {
            double result = 1 / fractionalPart;
            return (int) Math.round(result);
        } else {
            return 0;
        }

    }


}
