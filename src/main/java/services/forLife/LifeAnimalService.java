package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;

import java.util.List;

public class LifeAnimalService {
    private List<IslandObject> objectsInOneCoordinate;
    private Animal animal;
    private final EatingService eatingService;
//    private final ReproductionService reproductionService;
//    private final MovingService movingService;

    public LifeAnimalService() {
        this.eatingService = new EatingService();
//        this.reproductionService = new ReproductionService();
//        this.movingService = new MovingService();
    }
    public void lifeAnimals(List<IslandObject> objectsInOneCoordinate, Animal animal, Coordinate startCoordinate) {
        eatingService.eat(objectsInOneCoordinate, animal);
//        reproductionService.reproduction();
//        movingService.move();
    }
}
