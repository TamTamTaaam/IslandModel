package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import factory.AnimalFactory;
import lombok.SneakyThrows;

import java.util.List;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class DemographyService {
    private List<IslandObject> partWorldWithIslandObjects;
    private Animal animalForReproduction;
    private final AnimalFactory animalFactory;

    public DemographyService() {
        this.animalFactory = new AnimalFactory();
    }

    @SneakyThrows
    public void reproduction(List<IslandObject> partWorldWithIslandObjects, Animal animalForReproduction)  {
        this.partWorldWithIslandObjects = partWorldWithIslandObjects;
        this.animalForReproduction = animalForReproduction;
        if(checkMaxCountAnimalsOneTypeInOneCoordinate(getCountAnimalsOneTypeInOneCoordinate())) {
            Animal newAnimal = animalFactory.createAnimal(animalForReproduction.getNameAnimal());
            partWorldWithIslandObjects.add(newAnimal);
            System.out.println("+ новый " + newAnimal);
        }

    }
    private int getCountAnimalsOneTypeInOneCoordinate() {
        int countAnimalsOneType =0;
        for (IslandObject islandObject : partWorldWithIslandObjects) {
            if(islandObject.getClass().isAssignableFrom(animalForReproduction.getClass())) {
                countAnimalsOneType++;
            }
        }
        return countAnimalsOneType;
    }
    private boolean checkMaxCountAnimalsOneTypeInOneCoordinate(int countAnimalsInOneCoordinate) {
        int maxCountAnimalsInOneCoordinate = MAP_ALL_ANIMALS_IN_PROGRAM.get(animalForReproduction.getNameAnimal()).getMaxAmount();
        return countAnimalsInOneCoordinate < maxCountAnimalsInOneCoordinate;
    }
}
