import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.*;
import factory.AnimalCreationContext;
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
//        System.out.println("Name: " + mapAllAnimals.get("Mouse").getName());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getWeight());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxSatiety());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxAmount());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxSpeed());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").isCanBeEaten());
//        System.out.println("Weight: " + mapAllAnimals.get("Mouse").isCanEatAnimal());





//        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Projects\\IslandModel\\test.json"));
//        int a = jsonNode.get("Mouse").get("maxSpeed").asInt();
//        System.out.println(a);
//        JsonNode jsonNode1 = objectMapper.readTree(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristicsMap.json"));
//        Integer v1 = Stream.of(jsonNode1).map(e -> e.get("Mouse")).map(e -> e.get("maxAmount")).map(JsonNode::asInt).findFirst().get();







    }
}
