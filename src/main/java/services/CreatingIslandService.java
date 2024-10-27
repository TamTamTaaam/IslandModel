package services;
import island.Coordinate;
import island.IslandParameters;
import dataAnimals.Animal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CreatingIslandService {
    public ConcurrentHashMap<Coordinate, List<Animal>> ISLAND;
    private final IslandParameters ISLAND_PARAMETERS;
    private final int COUNT_COORDINATES;
    private final Map<Coordinate, Integer> countAnimalsInSomeCoordinate;


    public CreatingIslandService() {
        this.ISLAND_PARAMETERS = new ReadFileService().getCoordinates();
        this.countAnimalsInSomeCoordinate = creatingMapWithCountAnimalsInSomeCoordinate();
        this.COUNT_COORDINATES = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
    }


    public void creatingWorld() {
        Set<Map.Entry<Coordinate, Integer>> entries = countAnimalsInSomeCoordinate.entrySet();
        for (Map.Entry<Coordinate, Integer> map : entries) {
            List<Animal> animals = new ArrayList<>(); // !!!!!!!!
            ISLAND.putIfAbsent(map.getKey(), animals);
        }
    }

    private Map<Coordinate, Integer> creatingMapWithCountAnimalsInSomeCoordinate() {
        Map<Coordinate, Integer> countAnimalsInSomeCoordinate = new HashMap<>();
        int countAnimals =  ISLAND_PARAMETERS.getCountAnimals() / COUNT_COORDINATES;
        if(getStep()==0) {
            for (int i = 0; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 0; j <= ISLAND_PARAMETERS.getCoordinateY(); j++) {
                    countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                }
            }
        } else {
            int addCountAnimals = 0;
            for (int i = 0; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
                for (int j = 0; j <= ISLAND_PARAMETERS.getCoordinateY()-1; j++) {
                    int numberCoordinate = 1;
                    if((numberCoordinate%getStep())==0) {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                        addCountAnimals = addCountAnimals+countAnimals;
                    } else {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals+1);
                        addCountAnimals = addCountAnimals+countAnimals+1;
                    }
                    numberCoordinate++;
                }
            }
            int remainingAnimals = ISLAND_PARAMETERS.getCountAnimals()-addCountAnimals;
            countAnimalsInSomeCoordinate.put(new Coordinate(ISLAND_PARAMETERS.getCoordinateX(), ISLAND_PARAMETERS.getCoordinateY()), remainingAnimals);
        }
        return countAnimalsInSomeCoordinate;
    }

    private int getStep() {
        double countAnimals = (double) ISLAND_PARAMETERS.getCountAnimals() / COUNT_COORDINATES;
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
