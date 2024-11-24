package services.forLife;

import dataAnimals.Animal;
import dataAnimals.Herbivore;
import dataAnimals.IslandObject;
import dataAnimals.Plant;
import services.RandomNumberService;
import services.helper.SelectionOnlyAnimalsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static services.IslandLibrary.PLANT;

public class EatingService {
    private List<IslandObject> partWorldWithIslandObjects;
    private List<Animal> animalsInOneCoordinate;
    private final Plant plant;
    private final RandomNumberService randomNumberService;

    public EatingService() {
        this.randomNumberService = new RandomNumberService();
        this.plant = new Plant(PLANT.getWeight(), PLANT.getMaxAmount());
    }

    public void eat(List<IslandObject> partWorldWithIslandObjects, Animal animalForFeeding) {
        this.animalsInOneCoordinate = new SelectionOnlyAnimalsService().selectionAnimals(partWorldWithIslandObjects);
        this.partWorldWithIslandObjects = partWorldWithIslandObjects;
        selectCategoryFeeding(animalForFeeding);
    }

    private  void selectCategoryFeeding(Animal animalForFeeding) {
        if(((animalForFeeding.getChanceEatingAnimal() == null) || animalForFeeding.getChanceEatingAnimal().isEmpty()) && animalForFeeding instanceof Herbivore) {
            feedingHerbivores(animalForFeeding);
        } else if (!((animalForFeeding.getChanceEatingAnimal() == null) || animalForFeeding.getChanceEatingAnimal().isEmpty()) && !(animalForFeeding instanceof Herbivore)) {
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
        if(partWorldWithIslandObjects.contains(plant)) {
            int indexSomePlant = partWorldWithIslandObjects.lastIndexOf(plant);
            Plant somePlantForEating = (Plant) partWorldWithIslandObjects.get(indexSomePlant);
            double howMuchEat = somePlantForEating.getWeight();
            double satietyAfterEat = satietyControl(animalForFeeding, howMuchEat);
            animalForFeeding.setMaxSatiety(satietyAfterEat);
            partWorldWithIslandObjects.remove(indexSomePlant);
        }
        System.out.println(animalForFeeding + "поел");
    }
    private void feedingPredators(Animal animalForFeeding) {
        Map<String, Integer> chanceEatingAnimal = animalForFeeding.getChanceEatingAnimal();
        List<Animal> listOfAnimalsToEat = getListOfAnimalsToEat(chanceEatingAnimal);
        if(!(listOfAnimalsToEat.isEmpty())) {
            int i = 0;
            Integer randomNumber1 = randomNumberService.getRandomNumber(listOfAnimalsToEat.size());
            Animal animal = listOfAnimalsToEat.get(randomNumber1);
            while (i < 1) {
                int randomNumber = randomNumberService.getRandomNumber(101);
                if (randomNumber <= chanceEatingAnimal.get(animal.getNameAnimal())) {
                    double satietyAfterEating = satietyControl(animalForFeeding, animal.getWeight());
                    animalForFeeding.setMaxSatiety(satietyAfterEating);
                    partWorldWithIslandObjects.remove(animal);
                    i = i + 1;
                    System.out.println(animalForFeeding + "хищник съел " + animal);
                }
            }
        }

    }

    private List<Animal> getListOfAnimalsToEat(Map<String, Integer> chanceEatingAnimal) {
        List<Animal> animalsAsFood = new ArrayList<>();
        for(Map.Entry<String, Integer> map : chanceEatingAnimal.entrySet()) {
            String animalNameForFood = map.getKey();
            Animal animalForFood = MAP_ALL_ANIMALS_IN_PROGRAM.get(animalNameForFood);
            for (Animal animals: animalsInOneCoordinate) {
                if(animalForFood.getClass().isAssignableFrom(animals.getClass())) {
                    animalsAsFood.add(animals);
                }
            }
        }
        return animalsAsFood;
    }
    private double satietyControl(Animal animalForFeeding, double howMuchEat) {
        double satietyBeforeEating = animalForFeeding.getMaxSatiety();
        double satietyAfterEating = satietyBeforeEating+howMuchEat;
        double maxSatiety = MAP_ALL_ANIMALS_IN_PROGRAM.get(animalForFeeding.getNameAnimal()).getMaxSatiety();
        return Math.min(satietyAfterEating, maxSatiety);
    }


}
