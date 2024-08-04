package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.Animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAnimalsService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public List<Animal> getListAllAnimals() throws IOException {
        List<Animal> allAnimals = new ArrayList<>();

       // objectMapper.readValue(new File("AnimalCharacteristics.json"), allAnimals);

//        readValue(new File("test.json"), TestClass.class);
//        System.out.println(testClass);
        return allAnimals;
    }
}
