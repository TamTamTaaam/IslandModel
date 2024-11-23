package services.forLife;

import dataAnimals.Animal;
import dataAnimals.Herbivore;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import services.RandomNumberService;
import services.incessant.ChoiceAnimalService;
import services.incessant.SelectionOnlyAnimalsService;

import java.util.List;
import java.util.Map;

import static services.IslandLibrary.PLANT;

public class EatingService {
    private final ChoiceAnimalService choiceAnimalForFeeding;
    private List<IslandObject> islandObjects;
    private final Plant plant;
    private final SelectionOnlyAnimalsService selectionOnlyAnimalsFromList;
    private final RandomNumberService randomNumberService;

    public EatingService(List<IslandObject> islandObjects) {
        this.selectionOnlyAnimalsFromList = new SelectionOnlyAnimalsService();
        this.choiceAnimalForFeeding = new ChoiceAnimalService();
        this.islandObjects = islandObjects;
        this.randomNumberService = new RandomNumberService();
        this.plant = new Plant(PLANT.getWeight(), PLANT.getMaxAmount());
    }

    public void eat() {
        List<Animal> animals = selectionOnlyAnimalsFromList.selectionAnimals(islandObjects);
        Animal animalForFeeding = choiceAnimalForFeeding.choiceAnimal(animals);
        selectCategoryFeeding(animalForFeeding);
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
