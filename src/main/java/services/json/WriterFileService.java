package services.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WriterFileService {
    private final ObjectMapper objectMapper;

    public WriterFileService() {
        this.objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    @SneakyThrows
    public void writeFile(ConcurrentHashMap<Coordinate, List<IslandObject>> island) {
       // objectMapper.writeValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\ResultCountAnimalsSomeCoordinate.json"), createMapStatistic(island));
        objectMapper.writeValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\ResultAllIsland.json"), creatingMapStaticSumAllCoordinatesIsland(island));
    }

    private Map<Coordinate, Map<IslandObject, Integer>> createMapStatistic(ConcurrentHashMap<Coordinate, List<IslandObject>> island) {
        Map<Coordinate, Map<IslandObject, Integer>> statistic = new HashMap<>();
        for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
            Coordinate coordinate = map.getKey();
            statistic.put(coordinate, creatingMapStatisticOneCoordinate(map.getValue()));
        }
        return statistic;
    }

    private Map<IslandObject, Integer> creatingMapStatisticOneCoordinate(List<IslandObject> island) {
        Map<IslandObject, Integer> statisticOneCoordinate = new HashMap<>();
        for (IslandObject islandObjectInList : island) {
            statisticOneCoordinate.merge(islandObjectInList, 1, Integer::sum);
        }
        return statisticOneCoordinate;
    }
    private  Map<IslandObject, Integer> creatingMapStaticSumAllCoordinatesIsland(ConcurrentHashMap<Coordinate, List<IslandObject>> island) {
        Map<IslandObject, Integer> statistic = new HashMap<>();
        for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
            for (IslandObject islandObjectInList : map.getValue())
            statistic.merge(islandObjectInList, 1, Integer::sum);
        }
        return statistic;
    }
}
