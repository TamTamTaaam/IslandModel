package services.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
//        objectMapper.writeValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\ResultLifeIsland"), creatingMapStaticSumAllCoordinatesIsland(island));
        try {
            Path filePath = Path.of("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\ResultLifeIsland");
            String json = objectMapper.writeValueAsString(creatingMapStaticSumAllCoordinatesIsland(island)) + "\n";
            Files.write(filePath, json.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл: " + e.getMessage(), e);
        }

    }
       // objectMapper.writeValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\ResultCountAnimalsSomeCoordinate.json"), createMapStatistic(island));


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
