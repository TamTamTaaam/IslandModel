package services;

import dataAnimals.Animal;
import dataAnimals.Herbivore;

import java.util.*;

import static services.AnimalLibrary.*;

public class CheckDataService {
    public final List<Animal> listAnimal;

    public CheckDataService() {
        this.listAnimal = new ArrayList<>();
        for (Map.Entry<String, Animal> map : MAP_ALL_ANIMALS_IN_PROGRAM.entrySet()) {
            Animal animal = map.getValue();
            listAnimal.add(animal);
        }
    }

    public void CheckCharacteristicsAnimals(Map<String, Animal> allAnimals) {


    }
    private boolean CheckNegativeParameters() {
        boolean result = true;
        for (Animal animal : listAnimal) {
            if (animal.getWeight() <= 0 || animal.getMaxAmount() <= 0 || animal.getMaxSpeed() <= 0 || animal.getMaxSatiety() <= 0) {
                System.out.println("Ошибка! Отрицательные характеристики у животного" + animal.getNameAnimal());
                result = false;
            }
        }
        return result;
    }
    private boolean CheckDietOfAnimals() {
        boolean result = true;
        for (Animal animal : listAnimal) {
            if(animal.getChanceEatingAnimal().isEmpty() && !(animal instanceof Herbivore)) {
                System.out.println("Животное " + animal.getNameAnimal() + " не может питаться. Пустой список ChanceEatingAnimal и не является Herbivore");
                result = false;
            }
        }
        return result;
    }
    private boolean CheckPlantParameters() {
        boolean result = true;
        if(PLANT.getWeight()<=0 || PLANT.getMaxAmount()<=0) {
            System.out.println("Ошибка! Отрицательные характеристики растений");
            result = false;
        }
        return result;
    }

    private boolean CheckNegativeIslandParameters() {
        boolean result = true;
        if(ISLAND_PARAMETERS.getCoordinateY()<1 || ISLAND_PARAMETERS.getCoordinateX()<1 ) {
            System.out.println("Ошибка! Отрицательные координаты острова");
            result = false;
        }
        return result;
    }
    private boolean CheckCountAnimals() {
        boolean result = true;
        Integer limitAllAnimals = 0;
        Map<String, Integer> limitAnimal = new HashMap<>();
            for (Map.Entry<String, Animal> map : MAP_ALL_ANIMALS_IN_PROGRAM.entrySet()) {
                limitAnimal.put(map.getKey(), map.getValue().getMaxAmount());
            }

        return result;
    }
}
