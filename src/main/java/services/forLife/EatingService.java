package services.forLife;

import dataAnimals.Animal;
import dataAnimals.Herbivore;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import services.RandomNumberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static services.IslandLibrary.PLANT;

public class EatingService {
    private final RandomNumberService randomNumberService;
    private List<IslandObject> islandObjects;
    private final Plant plant;

    public EatingService(List<IslandObject> islandObjects) {
        this.randomNumberService = new RandomNumberService();
        this.islandObjects = islandObjects;
        this.plant = new Plant(PLANT.getWeight(), PLANT.getMaxAmount());
    }

    public void eat() {
        List<Animal> animals = selectionOnlyAnimalsFromList(islandObjects);
        Animal animalForFeeding = choiceAnimalForFeeding(animals);
        selectCategoryFeeding(animalForFeeding);

    }

    private List<Animal> selectionOnlyAnimalsFromList(List<IslandObject> islandObjects) {
        List<Animal> animals = new ArrayList<>();
        for (IslandObject islandObject : islandObjects) {
            if (islandObject instanceof Animal animal) {
                animals.add(animal);
            }
        }
        return animals;
    }
    private Animal choiceAnimalForFeeding(List<Animal> animals) {
        int randomNumberAnimal = randomNumberService.getRandomNumber(animals.size());
        return animals.get(randomNumberAnimal);
    }
    private  void selectCategoryFeeding(Animal animalForFeeding) {
        if(animalForFeeding.getChanceEatingAnimal().isEmpty() && animalForFeeding instanceof Herbivore) {
            feedingHerbivores(animalForFeeding);
        } else if (!animalForFeeding.getChanceEatingAnimal().isEmpty() && !(animalForFeeding instanceof Herbivore)) {
            feedingPredators(animalForFeeding);
        } else {
            int selectCategoryFeeding = randomNumberService.getRandomNumber(2);
            if(selectCategoryFeeding==0) {
                feedingPredators(animalForFeeding);
            } else {
                feedingHerbivores(animalForFeeding);
            }
        }
    }

    private void feedingHerbivores(Animal animalForFeeding) {
        if(islandObjects.contains(plant)) {
            int indexSomePlant = islandObjects.lastIndexOf(plant);
            double satietyBeforeEating = animalForFeeding.getMaxSatiety();
            Plant somePlantForEating = (Plant) islandObjects.get(indexSomePlant);
            animalForFeeding.setMaxSatiety(satietyBeforeEating+somePlantForEating.getWeight());
            islandObjects.remove(indexSomePlant);
        }
    }
    private void feedingPredators(Animal animalForFeeding) {
        Map<String, Integer> chanceEatingAnimal = animalForFeeding.getChanceEatingAnimal();

    }


}
