package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dataAnimals.Animal;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReadAnimalsService {
    private final ObjectMapper objectMapper = new ObjectMapper();


    public Map<String, Animal> getMapAllAnimals() throws IOException {

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

}
