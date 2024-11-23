import dataAnimals.IslandObject;
import island.Coordinate;
import services.IslandLibrary;
import services.IslandLife;
import services.creatingField.CreatingStartingFieldService;
import services.json.WriterFileService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;


public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException, InterruptedException {


        IslandLife islandLife = new IslandLife();
        islandLife.life();
        System.out.println("the end");

//        IslandLife islandLife = new IslandLife();
//        ConcurrentHashMap<Coordinate, List<IslandObject>> island = islandLife.island;
//        for (Map.Entry<Coordinate, List<IslandObject>> pair: island.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//        System.out.println("the end");



//        CreatingStartingFieldService creatingIslandService = new CreatingStartingFieldService();
//        ConcurrentHashMap<Coordinate, List<IslandObject>> coordinateIntegerMap = creatingIslandService.ISLAND;
//        WriterFileService writerFileService = new WriterFileService();
//        writerFileService.writeFile(coordinateIntegerMap);
//        Set<Map.Entry<Coordinate, List<IslandObject>>> entries = coordinateIntegerMap.entrySet();
//        int countCoordinate = 0;
//        for (Map.Entry<Coordinate, List<IslandObject>> pair: entries) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//            countCoordinate++;
//        }
//        System.out.println(countCoordinate);


    }
}
