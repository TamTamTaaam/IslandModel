package factory;
import dataAnimals.*;
import lombok.SneakyThrows;
import services.RandomNumberService;
import java.util.Map;
import java.util.function.Function;

import static services.IslandLibrary.LIST_ALL_ANIMALS_IN_PROGRAM;
import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class AnimalFactory {
    private final RandomNumberService randomNumberService;

    public AnimalFactory() {
        this.randomNumberService = new RandomNumberService();
    }
    private final Map<String, Function<AnimalCreationContext, Animal>> ALL_ANIMALS_MAP = Map.ofEntries(
            Map.entry("Wolf", Wolf::new),
            Map.entry("Bear", Bear::new),
            Map.entry("Fox", Fox::new),
            Map.entry("Eagle", Eagle::new),
            Map.entry("Horse", Horse::new),
            Map.entry("Mouse", Mouse::new),
            Map.entry("Rabbit", Rabbit::new),
            Map.entry("Snake", Snake::new),
            Map.entry("Worm", Worm::new)
    );

    @SneakyThrows
    public Animal createAnimalsStart() {
        int randomNumberOfAnimalInList = randomNumberService.getRandomNumber(LIST_ALL_ANIMALS_IN_PROGRAM.size());
        String keyAnimal = LIST_ALL_ANIMALS_IN_PROGRAM.get(randomNumberOfAnimalInList);
        Animal animal = MAP_ALL_ANIMALS_IN_PROGRAM.get(keyAnimal);
        AnimalCreationContext parameters = new AnimalCreationContext(animal.getName(), animal.getNameAnimal(), animal.getWeight(), animal.getMaxAmount(), animal.getMaxSpeed(), animal.getMaxSatiety(), animal.getChanceEatingAnimal());
        if (!ALL_ANIMALS_MAP.containsKey(keyAnimal)) {
            throw new IllegalAccessException();
        }
        Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimal);
        return animalFunction.apply(parameters);
    }
    @SneakyThrows
    public Animal createAnimal(String keyAnimalName) {
        Animal animal = MAP_ALL_ANIMALS_IN_PROGRAM.get(keyAnimalName);
        AnimalCreationContext parameters = new AnimalCreationContext(animal.getName(), animal.getNameAnimal(), animal.getWeight(), animal.getMaxAmount(), animal.getMaxSpeed(), animal.getMaxSatiety(), animal.getChanceEatingAnimal());
        if (!ALL_ANIMALS_MAP.containsKey(keyAnimalName)) {
            throw new IllegalAccessException();
        }
        Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimalName);
        return animalFunction.apply(parameters);
    }
}


