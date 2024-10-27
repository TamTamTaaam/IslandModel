import dataAnimals.*;
import factory.AnimalFactory;
import island.Coordinate;
import services.CreatingIslandService;
import services.CreatingOneCoordinateService;
import services.ReadFileService;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("hello hello");

        CreatingIslandService creatingIslandService = new CreatingIslandService();
        Map<Coordinate, Integer> countAnimalsInSomeCoordinates = creatingIslandService.countAnimalsInSomeCoordinates;
        Set<Map.Entry<Coordinate, Integer>> entries = countAnimalsInSomeCoordinates.entrySet();
        int sum = 0;
        for (Map.Entry<Coordinate, Integer> map : entries) {
           sum = sum + map.getValue();
        }
        System.out.println(sum);


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
