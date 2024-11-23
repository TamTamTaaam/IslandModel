package services;

import dataAnimals.Animal;
import dataAnimals.Herbivore;

import java.util.*;

import static services.IslandLibrary.*;

public class CheckDataService {
    private final List<Animal> listAnimal;
    public CheckDataService() {
        this.listAnimal = new ArrayList<>();
        for (Map.Entry<String, Animal> map : MAP_ALL_ANIMALS_IN_PROGRAM.entrySet()) {
            Animal animal = map.getValue();
            listAnimal.add(animal);
        }
    }

    public boolean CheckCharacteristics() {
        return CheckNegativeParameters() && CheckDietOfAnimals() && CheckPlantParameters() && CheckNegativeIslandParameters() && CheckCountAnimals();
    }
    private boolean CheckNegativeParameters() {
        boolean result = true;
        for (Animal animal : listAnimal) {
            if (animal.getWeight() <= 0 || animal.getMaxAmount() <= 0 || animal.getMaxSpeed() < 0 || animal.getMaxSatiety() <= 0) {
                System.out.println("Ошибка! Отрицательные характеристики у животного" + animal.getNameAnimal());
                result = false;
            }
        }
        return result;
    }
    private boolean CheckDietOfAnimals() {
        boolean result = true;
        for (Animal animal : listAnimal) {
            if(animal.getChanceEatingAnimal()==null && !(animal instanceof Herbivore)) {
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
        if(ISLAND_PARAMETERS.getCoordinateY()<1 || ISLAND_PARAMETERS.getCoordinateX()<1 || ISLAND_PARAMETERS.getTactTime()<1) {
            System.out.println("Ошибка! Отрицательные координаты острова");
            result = false;
        }
        return result;
    }
    private boolean CheckCountAnimals() {
        boolean result = true;
        int sumAnimal = 0;
            for (Map.Entry<String, Animal> map : MAP_ALL_ANIMALS_IN_PROGRAM.entrySet()) {
                sumAnimal = sumAnimal+map.getValue().getMaxAmount();
            }
        int countCoordinates = ISLAND_PARAMETERS.getCoordinateX()*ISLAND_PARAMETERS.getCoordinateY();
        int maxCountAnimalInIsland = countCoordinates*sumAnimal;
        if(ISLAND_PARAMETERS.getCountAnimals()>maxCountAnimalInIsland) {
            System.out.println("Ошибка! Большое значение countAnimals, невозможно разместить животных на поле");
            result = false;
        }
        return result;
    }
}
