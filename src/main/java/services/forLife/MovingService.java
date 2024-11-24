package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import services.IslandLife;
import services.RandomNumberService;
import services.helper.CreateMapLimitAnimals;
import services.helper.CreatingListAllCoordinatesInIsland;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class MovingService {
    private Coordinate startCoordinate;
    private Animal animal;
    private final List<Coordinate> coordinatesInIsland;
    private List<Coordinate> animalMovementOptions;
    private final RandomNumberService randomNumberService;
    private final IslandLife islandLife;
    private final Map<String, Integer> mapLimitAnimals;
    public MovingService() {
        this.coordinatesInIsland = new CreatingListAllCoordinatesInIsland().coordinatesInIsland;
        this.randomNumberService = new RandomNumberService();
        this.islandLife = new IslandLife();
        this.mapLimitAnimals = new CreateMapLimitAnimals().MAP_WITH_LIMIT_COUNT_ANIMALS_IN_COORDINATES;
    }
    public void move(Coordinate startCoordinate, Animal animal) {
        this.animal = animal;
        this.startCoordinate = startCoordinate;
        this.animalMovementOptions = getAnimalMovementOptions();
        if(!(animalMovementOptions.isEmpty())) {
            Coordinate coordinateAfterMove = getNewCoordinate();
            boolean add = islandLife.ISLAND.get(coordinateAfterMove).add(animal);
            if (add == true) {
                islandLife.ISLAND.get(startCoordinate).remove(animal);
                System.out.println(animal + "переместился на " + coordinateAfterMove);
            }
        }
    }
    private List<Coordinate> getAnimalMovementOptions() {
        int maxSpeedAnimal = MAP_ALL_ANIMALS_IN_PROGRAM.get(animal.getNameAnimal()).getMaxSpeed();
        List<Coordinate> movementOptions = new ArrayList<>();
        for (int i = -maxSpeedAnimal; i<=maxSpeedAnimal; i++) {
            Coordinate horizontalMove = new Coordinate(startCoordinate.getX()+i, startCoordinate.getY());
            Coordinate verticalMove = new Coordinate(startCoordinate.getX(), startCoordinate.getY()+i);
            if(coordinatesInIsland.contains(horizontalMove) && checkCountAnimalInCoordinate(horizontalMove)) {
                movementOptions.add(horizontalMove);
            }
            if (coordinatesInIsland.contains(verticalMove) && checkCountAnimalInCoordinate(verticalMove)) {
                movementOptions.add(verticalMove);
            }
        }
        return movementOptions;
    }

    private Coordinate getNewCoordinate() {
        Integer randomNumber = randomNumberService.getRandomNumber(animalMovementOptions.size());
        return animalMovementOptions.get(randomNumber);
    }
    private int countAnimalsInFoundCoordinate(Coordinate newCoordinate) {
        List<IslandObject> islandObjects = islandLife.ISLAND.get(newCoordinate);
        int countAnimalInCoordinate = 0;
        for (IslandObject islandObject: islandObjects) {
            if(islandObject.getClass().isAssignableFrom(animal.getClass())) {
                countAnimalInCoordinate++;
            }
        }
        return countAnimalInCoordinate;
    }
    private boolean checkCountAnimalInCoordinate(Coordinate newCoordinate) {
        int countAnimals = countAnimalsInFoundCoordinate(newCoordinate);
        return countAnimals < mapLimitAnimals.get(animal.getNameAnimal());
    }
}
