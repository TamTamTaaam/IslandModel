package factory;
import dataAnimals.*;
import services.RandomNumberService;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import static dataAnimals.AnimalLibrary.LIST_ALL_ANIMALS_IN_PROGRAM;
import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;


public class AnimalFactory {

    private final RandomNumberService randomNumberService = new RandomNumberService();

    public AnimalFactory() throws IOException {
    }

        private final Map<String, Function<AnimalCreationContext, Animal>> ALL_ANIMALS_MAP = Map.ofEntries(
                Map.entry("Wolf", Wolf::new),
                Map.entry("Bear", Bear::new),
                Map.entry("Fox", Fox::new),
                Map.entry("Eagle", Eagle::new),
                Map.entry("Horse", (parameters) -> new Horse(parameters)),
                Map.entry("Mouse", (parameters) -> new Mouse(parameters)),
                Map.entry("Rabbit", (parameters) -> new Rabbit(parameters)),
                Map.entry("Snake", (parameters) -> new Snake(parameters)),
                Map.entry("Worm", (parameters) -> new Worm(parameters))
        );

        public Animal createAnimal( ) throws IllegalAccessException {
            int randomNumberOfAnimalInList = randomNumberService.getRandomNumber(LIST_ALL_ANIMALS_IN_PROGRAM.size());
            String keyAnimal = LIST_ALL_ANIMALS_IN_PROGRAM.get(randomNumberOfAnimalInList);
            Animal animal = MAP_ALL_ANIMALS_IN_PROGRAM.get(keyAnimal);
            AnimalCreationContext parameters = new AnimalCreationContext(animal.getName(), animal.getNameAnimal(), animal.getWeight(), animal.getMaxAmount(), animal.getMaxSpeed(), animal.getMaxSatiety(), animal.getChanceEatingAnimal());
            if(!ALL_ANIMALS_MAP.containsKey(keyAnimal)) {
                throw new IllegalAccessException();
            }
            Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimal);
            return animalFunction.apply(parameters);
        }
}


