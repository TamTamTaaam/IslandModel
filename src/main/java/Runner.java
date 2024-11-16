import dataAnimals.*;
import island.Coordinate;
import services.WriterFileService;
import services.creatingField.CreatingStartingFieldService;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {

//        System.out.println("hello hello");
//        CreatingStartingFieldService creatingIslandService = new CreatingStartingFieldService();
//        ConcurrentHashMap<Coordinate, List<IslandObject>> island = creatingIslandService.ISLAND;
//        Coordinate coo = new Coordinate(1,1);
//        List<IslandObject> orDefault = island.get(coo);
//
//        System.out.println(island);
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


        CreatingStartingFieldService creatingIslandService = new CreatingStartingFieldService();
        ConcurrentHashMap<Coordinate, List<IslandObject>> coordinateIntegerMap = creatingIslandService.ISLAND;
        WriterFileService writerFileService = new WriterFileService();
        writerFileService.writeFile(coordinateIntegerMap);
        Set<Map.Entry<Coordinate, List<IslandObject>>> entries = coordinateIntegerMap.entrySet();
        int countCoordinate = 0;
        for (Map.Entry<Coordinate, List<IslandObject>> pair: entries) {
            System.out.println(pair.getKey() + " " + pair.getValue());
            countCoordinate++;
        }
        System.out.println(countCoordinate);

    }
}
