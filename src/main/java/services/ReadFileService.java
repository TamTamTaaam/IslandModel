package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.Animal;
import dataAnimals.Plant;
import island.IslandParameters;
import lombok.SneakyThrows;


import java.io.File;
import java.util.*;


public class ReadFileService {
    private final ObjectMapper objectMapper;

    public ReadFileService() {
        this.objectMapper = new ObjectMapper();
    }

    @SneakyThrows
    public Map<String, Animal> readMapAllAnimals() {

        return objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristicsMap.json"),
                new TypeReference<HashMap<String, Animal>>() {
                });
    }
    public List<String> createListAnimals(Map<String, Animal> mapAnimals) {
        List<String> resultListAnimals = new ArrayList<>();
        for (Map.Entry<String, Animal> map : mapAnimals.entrySet()) {
            String key = map.getKey();
            resultListAnimals.add(key);
        }
        return resultListAnimals;
    }
    @SneakyThrows
    public IslandParameters readCoordinates()  {
        return objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\CoordinatesIsland.json"),
                IslandParameters.class);
    }
    @SneakyThrows
    public Plant readPlant()  {
        return objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\Plant.json"),
                Plant.class);
    }
}
