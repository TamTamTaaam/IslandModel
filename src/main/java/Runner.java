import dataAnimals.*;
import island.Coordinate;
import lombok.SneakyThrows;
import services.IslandLibrary;
import services.IslandLife;
import services.creatingField.CreatingStartingFieldService;
import services.forLife.EatingService;
import services.json.WriterFileService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static services.IslandLibrary.PLANT;


public class Runner {
    @SneakyThrows
    public static void main(String[] args)  {


        IslandLife islandLife = new IslandLife();
        islandLife.life();
        System.out.println("the end");

//        Animal animal = new Rabbit();
//        Class<? extends Animal> animalClass = animal.getClass();
//        Animal newAnimal = animalClass.getDeclaredConstructor().newInstance();
//
//        System.out.println(newAnimal);
//        System.out.println(newAnimal.getNameAnimal());

//        IslandLife islandLife = new IslandLife();
//        EatingService eatingService = new EatingService();
//        List<IslandObject> is = new ArrayList<>();
//        is.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
//        is.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
//        is.add(new Mouse());
//        is.add(new Wolf());
//        is.add(new Rabbit());
//        Animal animal = new Rabbit();
//        is.add(animal);
////        eatingService.eat(is, animal);
////        System.out.println(is);
//        System.out.println(animal.getName());
//        System.out.println(MAP_ALL_ANIMALS_IN_PROGRAM.get(animal.getName()));
//        System.out.println(MAP_ALL_ANIMALS_IN_PROGRAM.get(animal.getNameAnimal()).getMaxSatiety());





//        CreatingStartingFieldService creatingIslandService = new CreatingStartingFieldService();
//        ConcurrentHashMap<Coordinate, List<IslandObject>> coordinateIntegerMap = creatingIslandService.ISLAND;
//        Set<Map.Entry<Coordinate, List<IslandObject>>> entries = coordinateIntegerMap.entrySet();
//        for (Map.Entry<Coordinate, List<IslandObject>> pair: entries) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//            EatingService eatingService = new EatingService();
//            Animal animal = (Animal) pair.getValue().get(0);
//            eatingService.eat(pair.getValue(), animal);
//
//        }

    }
}
