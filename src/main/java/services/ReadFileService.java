package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.Animal;
import island.IslandParameters;
import lombok.SneakyThrows;


import java.io.File;
import java.util.*;


public class ReadFileService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public Map<String, Animal> getMapAllAnimals() {

        Map<String, Animal> animals = objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristicsMap.json"),
                new TypeReference<HashMap<String, Animal>>() {
                });
        return animals;
    }

    public List<String> createListAnimals(Map<String, Animal> mapAnimals) {
        List<String> resultListAnimals = new ArrayList<>();
        Set<Map.Entry<String, Animal>> entries = mapAnimals.entrySet();
        for (Map.Entry<String, Animal> map : entries) {
            String key = map.getKey();
            resultListAnimals.add(key);
        }
        return resultListAnimals;
    }

    @SneakyThrows
    public IslandParameters getCoordinates()  {
        IslandParameters coordinates = objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\CoordinatesIsland.json"),
                IslandParameters.class);
        return coordinates;
    }


}
