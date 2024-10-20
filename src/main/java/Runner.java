import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.*;
import factory.AnimalFactory;
import services.RandomNumberService;
import services.ReadAnimalsService;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("hello hello");
        AnimalFactory animalFactory = new AnimalFactory();
       System.out.println(AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM);

        for (int i = 0; i < 4; i++) {
            Animal animal = animalFactory.createAnimal();
            System.out.println(animal + " " + animal.getMaxSatiety());
        }









    }
}
