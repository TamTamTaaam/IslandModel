package services.forLife;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import services.RandomNumberService;
import services.incessant.ChoiceAnimalService;
import services.incessant.SelectionOnlyAnimalsService;

import java.util.List;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static services.IslandLibrary.PLANT;

public class ReproductionService {
    private List<IslandObject> partWorldWithIslandObjects;
    private Animal animalForReproduction;
    public ReproductionService(List<IslandObject> partWorldWithIslandObjects, Animal animalForReproduction) {
        this.partWorldWithIslandObjects = partWorldWithIslandObjects;
        this.animalForReproduction = animalForReproduction;
    }
    public void reproduction() {
        if(checkMaxCountAnimalsOneTypeInOneCoordinate(getCountAnimalsOneTypeInOneCoordinate())) {


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
