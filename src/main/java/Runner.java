import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.*;
import factory.AnimalCreationContext;
import factory.AnimalFactory;
import services.ReadAnimalsService;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("hello hello");

        ObjectMapper objectMapper = new ObjectMapper();
        ReadAnimalsService readAnimalsService = new ReadAnimalsService();
       /* System.out.println(readAnimalsService.getListAllAnimals());*/
        Map<String, Animal> mapAllAnimals = readAnimalsService.getMapAllAnimals();
        System.out.println(mapAllAnimals);







    }
}
