import dataAnimals.*;
import factory.AnimalFactory;
import island.Coordinate;
import services.CreatingIslandService;
import services.CreatingOneCoordinateService;
import services.ReadFileService;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("hello hello");
        CreatingIslandService creatingIslandService = new CreatingIslandService();
        ConcurrentHashMap<Coordinate, List<IslandObject>> island = creatingIslandService.ISLAND;
        Coordinate coo = new Coordinate(1,1);
        List<IslandObject> orDefault = island.get(coo);

        System.out.println(island);
/*
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.createAnimal();
        System.out.println(animal.getMaxAmount());*/


//        Set<Map.Entry<String, Animal>> entries = mapAnimals.entrySet();
//        for (Map.Entry<String, Animal> map : entries) {
//            String key = map.getKey();
//            resultListAnimals.add(key);
//        }
//        return resultListAnimals;


//        CreatingIslandService creatingIslandService = new CreatingIslandService();
//        Map<Coordinate, Integer> coordinateIntegerMap = creatingIslandService.creatingMapWithCountAnimalsInSomeCoordinate();
//        Set<Map.Entry<Coordinate, Integer>> entries = coordinateIntegerMap.entrySet();
//        int count = 0;
//        int countCoordinate = 0;
//        for (Map.Entry<Coordinate, Integer> pair: entries) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//            count = count + pair.getValue();
//            countCoordinate++;
//        }
//        System.out.println(count);
//        System.out.println(countCoordinate);

        


//        AnimalFactory animalFactory = new AnimalFactory();
//        Animal wolf = new Wolf();
//
//        for (int i = 0; i < 4; i++) {
//            String str = "o";
//            Animal animal = animalFactory.createAnimal();
//            if (animal.getClass().equals(wolf.getClass()) ) {
//                 str = "yes";
//            }
//            else {
//                str = "no";
//            }
//
//            System.out.println(animal + " " + animal.getClass() + " " + str);
//        }


//        ReadFileService readFileService = new ReadFileService();
//
//        CreatingIslandService creatingIslandService = new CreatingIslandService();
//        System.out.println(creatingIslandService.ISLAND_PARAMETERS);





    }
}
