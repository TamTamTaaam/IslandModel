package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;

import java.util.List;

public class MovingService {
    private Coordinate startCoordinate;
    private Animal animal;
    public MovingService(Coordinate startCoordinate, Animal animal) {
        this.startCoordinate = startCoordinate;
        this.animal = animal;
    }
    public void move() {

    }
}
