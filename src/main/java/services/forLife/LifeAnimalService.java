package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;

import java.util.List;

public class LifeAnimalService {
    private List<IslandObject> objectsInOneCoordinate;
    private Animal animal;
    private final EatingService eatingService;
    private final DemographyService demographyService;
//    private final MovingService movingService;

    public LifeAnimalService() {
        this.eatingService = new EatingService();
        this.demographyService = new DemographyService();
//        this.reproductionService = new ReproductionService();
//        this.movingService = new MovingService();
    }
    public void lifeAnimals(List<IslandObject> objectsInOneCoordinate, Animal animal, Coordinate startCoordinate) {
        eatingService.eat(objectsInOneCoordinate, animal);
        demographyService.reproduction(objectsInOneCoordinate, animal);
//        reproductionService.reproduction();
//        movingService.move();
    }
}
