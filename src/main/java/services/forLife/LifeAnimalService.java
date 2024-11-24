package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;

import java.util.List;

public class LifeAnimalService {
    private final EatingService eatingService;
    private final DemographyService demographyService;
    private final MovingService movingService;

    public LifeAnimalService() {
        this.eatingService = new EatingService();
        this.demographyService = new DemographyService();
        this.movingService = new MovingService();
    }
    public void lifeAnimals(List<IslandObject> objectsInOneCoordinate, Animal animal, Coordinate startCoordinate) {
        eatingService.eat(objectsInOneCoordinate, animal);
        demographyService.reproduction(objectsInOneCoordinate, animal);
        movingService.move(startCoordinate, animal);
    }
}
