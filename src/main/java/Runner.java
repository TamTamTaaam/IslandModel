import dataAnimals.*;
import island.Coordinate;
import services.IslandLibrary;
import services.IslandLife;
import services.creatingField.CreatingStartingFieldService;
import services.forLife.EatingService;
import services.json.WriterFileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;
import static services.IslandLibrary.PLANT;


public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException, InterruptedException {


//        IslandLife islandLife = new IslandLife();
//        islandLife.life();
//        System.out.println("the end");
        EatingService eatingService = new EatingService();
        List<IslandObject> is = new ArrayList<>();
        is.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
        is.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
        is.add(new Mouse());
        is.add(new Wolf());
        is.add(new Rabbit());
        Animal animal = new Rabbit();
        is.add(animal);
        eatingService.eat(is, animal);
        System.out.println(is);





//        CreatingStartingFieldService creatingIslandService = new CreatingStartingFieldService();
//        ConcurrentHashMap<Coordinate, List<IslandObject>> coordinateIntegerMap = creatingIslandService.ISLAND;
//        Set<Map.Entry<Coordinate, List<IslandObject>>> entries = coordinateIntegerMap.entrySet();
//        for (Map.Entry<Coordinate, List<IslandObject>> pair: entries) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
////            EatingService eatingService = new EatingService(pair.getValue());
//            Animal animal = (Animal) pair.getValue().get(0);
//
//        }

    }
}
