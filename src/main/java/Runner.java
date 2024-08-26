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
        System.out.println("Name: " + mapAllAnimals.get("Mouse").getName());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getWeight());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxSatiety());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxAmount());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").getMaxSpeed());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").isCanBeEaten());
        System.out.println("Weight: " + mapAllAnimals.get("Mouse").isCanEatAnimal());





//        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Projects\\IslandModel\\test.json"));
//        int a = jsonNode.get("Mouse").get("maxSpeed").asInt();
//        System.out.println(a);
//        JsonNode jsonNode1 = objectMapper.readTree(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristicsMap.json"));
//        Integer v1 = Stream.of(jsonNode1).map(e -> e.get("Mouse")).map(e -> e.get("maxAmount")).map(JsonNode::asInt).findFirst().get();




//        Map <String, Animal> animalsMap = new HashMap<>();
//        animalsMap.put("Bear", new Bear(new AnimalCreationContext()));
//        animalsMap.put("Fox", new Fox(new AnimalCreationContext()));
//        animalsMap.put("Mouse", new Mouse(new AnimalCreationContext()));
//        objectMapper.writeValue(new File("test.json"), animalsMap);

//        List<Animals> animals = new ArrayList<>();
//        animals.add(new Bear());
//        animals.add(new Rabbit());
//        animals.add(new Fox());
//        objectMapper.writeValue(new File("test.json"), animals);
//        objectMapper.readValue(new File("test.json"), new TypeReference<List<Animals>>() {});

//        try {
//            JsonNode rootNode = objectMapper.readTree(new File("C:\\Projects\\IslandModel\\src\\main\\java\\configs\\AnimalCharacteristics.json"));
//            JsonNode animalsNode = rootNode.get("Animals");
//            Animals[] animals = objectMapper.convertValue(animalsNode, Animals[].class);
//            for (Animals animal : animals) {
//                System.out.println(animal);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        objectMapper.writeValue(new File("test.json"), hello);
//        TestClass testClass = objectMapper.readValue(new File("test.json"), TestClass.class);
//        System.out.println(testClass);
//
//        JsonNode jsonNode = objectMapper.readTree(new File("test.json"));
//        int i = jsonNode.get("a").asInt();

        //ObjectMapper mapper = new ObjectMapper();

//        try {
//            // Чтение из файла и десериализация массива Animals
//            Animals[] animals = mapper.readValue(new File("path/to/your/json/file.json"), Animals[].class);
//
//            // Преобразование массива в список, если нужно
//            List<Animals> animalsList = Arrays.asList(animals);
//
//            // Вывод результатов
//            for (Animals animal : animalsList) {
//                System.out.println(animal);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
