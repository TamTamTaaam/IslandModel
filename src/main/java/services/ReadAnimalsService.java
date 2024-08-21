package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.Animal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReadAnimalsService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public List<Animal> getListAllAnimals() throws IOException {

        List<Animal> animals = objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristics.json"),
                new TypeReference<List<Animal>>() {
        });
        return animals;
    }
    public Map<String, Animal> getMapAllAnimals() throws IOException {

        Map<String, Animal> animals = objectMapper.readValue(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristics.json"),
                new TypeReference<Map<String, Animal>>() {
                });
        return animals;
    }
}
