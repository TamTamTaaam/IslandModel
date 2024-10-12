import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.*;
import factory.AnimalCreationContext;
import factory.AnimalFactory;
import services.RandomNumberService;
import services.ReadAnimalsService;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("hello hello");
        AnimalFactory animalFactory = new AnimalFactory();
        for (int i = 0; i < 4; i++) {

            System.out.println(animalFactory.createAnimal());

        }








    }
}
