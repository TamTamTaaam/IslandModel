import dataAnimals.*;
import factory.AnimalFactory;
import island.Coordinate;
import services.CreatingIslandService;
import services.CreatingOneCoordinateService;
import services.ReadFileService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("hello hello");
        CreatingIslandService creatingIslandService = new CreatingIslandService();
        ConcurrentHashMap<Coordinate, List<Animal>> island = creatingIslandService.ISLAND;
        System.out.println(island);


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
