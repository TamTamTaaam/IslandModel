import com.fasterxml.jackson.databind.ObjectMapper;
import dataAnimals.*;
import factory.AnimalCreationContext;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("hello hello");

        ObjectMapper objectMapper = new ObjectMapper();
        TestClass hello = new TestClass(1, "hello");

        Map <String, Animal> animalsMap = new HashMap<>();
        animalsMap.put("Bear", new Bear(new AnimalCreationContext()));
        animalsMap.put("Fox", new Fox(new AnimalCreationContext()));
        animalsMap.put("Mouse", new Mouse(new AnimalCreationContext()));
        objectMapper.writeValue(new File("test.json"), animalsMap);

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
