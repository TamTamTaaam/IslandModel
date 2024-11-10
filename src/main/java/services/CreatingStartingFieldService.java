package services;
import dataAnimals.IslandObject;
import island.Coordinate;
import java.util.*;
import java.util.concurrent.*;

import static dataAnimals.AnimalLibrary.ISLAND_PARAMETERS;

public class CreatingStartingFieldService {
    public ConcurrentHashMap<Coordinate, List<IslandObject>> ISLAND;
    private final int COUNT_COORDINATES;
    private final Map<Coordinate, Integer> LIMIT_COUNT_ANIMALS_IN_SOME_COORDINATES;
    private final CreatingOneCoordinateService creatingOneCoordinateService;


    public CreatingStartingFieldService() {
        this.COUNT_COORDINATES = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
        this.LIMIT_COUNT_ANIMALS_IN_SOME_COORDINATES = creatingMapWithLimitCountAnimalsInSomeCoordinate();
        creatingOneCoordinateService = new CreatingOneCoordinateService();
        this.ISLAND = creatingWorld();
    }

//    private ConcurrentHashMap<Coordinate, List<IslandObject>> creatingWorld()  {
//        ConcurrentHashMap<Coordinate, List<IslandObject>> island = new ConcurrentHashMap<>();
//        Set<Map.Entry<Coordinate, Integer>> entries = LIMIT_COUNT_ANIMALS_IN_SOME_COORDINATES.entrySet();
//            for (Map.Entry<Coordinate, Integer> map : entries) {
//                List<IslandObject> islandObjects = creatingOneCoordinateService.creatingListIslandObjectInSomeCoordinate(map.getValue());
//                island.putIfAbsent(map.getKey(), islandObjects);
//            }
//        return island;
//    }
    private ConcurrentHashMap<Coordinate, List<IslandObject>> creatingWorld()  {
        ConcurrentHashMap<Coordinate, List<IslandObject>> island = new ConcurrentHashMap<>();
        Set<Map.Entry<Coordinate, Integer>> entries = LIMIT_COUNT_ANIMALS_IN_SOME_COORDINATES.entrySet();
        try (ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            List<Future<?>> futures = new ArrayList<>();
            for (Map.Entry<Coordinate, Integer> map : entries) {
                futures.add(executorService.submit(() -> {
                    List<IslandObject> islandObjects = creatingOneCoordinateService.creatingListIslandObjectInSomeCoordinate(map.getValue());
                    island.putIfAbsent(map.getKey(), islandObjects);
                }));
            }
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Error CreatingStartingFieldService");
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        }
        return island;
    }

    private Map<Coordinate, Integer> creatingMapWithLimitCountAnimalsInSomeCoordinate() {
        Map<Coordinate, Integer> countAnimalsInSomeCoordinate = new HashMap<>();
        int countAnimals =  ISLAND_PARAMETERS.getCountAnimals() / COUNT_COORDINATES;
        int numberCoordinate = 0;
        for (int i = 1; i <= ISLAND_PARAMETERS.getCoordinateX(); i++) {
            for (int j = 1; j <= ISLAND_PARAMETERS.getCoordinateY(); j++) {
                if(getStepCoordinateWithCountAnimalsMoreThanRest()==0) {
                    countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                } else {
                    if(((numberCoordinate+1)%getStepCoordinateWithCountAnimalsMoreThanRest())!=0) {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals);
                    } else {
                        countAnimalsInSomeCoordinate.put(new Coordinate(i, j), countAnimals+1);
                    }
                }
                numberCoordinate++;
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
