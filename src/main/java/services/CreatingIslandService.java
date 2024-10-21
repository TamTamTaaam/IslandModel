package services;

import island.Coordinate;
import island.IslandParameters;
import dataAnimals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CreatingIslandService {
    public ConcurrentHashMap<Coordinate, List<Animal>> ISLAND;
    public final IslandParameters ISLAND_PARAMETERS;

    public CreatingIslandService() {
        this.ISLAND_PARAMETERS = new ReadFileService().getCoordinates();
    }

    public void creatingWorld() {
        for (int i = 0; i < ISLAND_PARAMETERS.getCoordinateX(); i++) {
            for (int j = 0; j < ISLAND_PARAMETERS.getCoordinateY(); j++) {
                List<Animal> animalsInOneCoordinate = new ArrayList<>();
                int countAnimalsOneCoordinate = ISLAND_PARAMETERS.getCountAnimals();
                for (int k = 0; k < 1000 ; k++) {

                }

            }

        }
    }



}
