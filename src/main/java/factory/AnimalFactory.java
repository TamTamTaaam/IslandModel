package factory;
import dataAnimals.*;
import services.RandomNumberService;

import java.io.IOException;

import static dataAnimals.LibraryAnimal.LIST_ALL_ANIMALS_IN_PROGRAM;

public class AnimalFactory {

    private final RandomNumberService randomNumberService = new RandomNumberService();

    public AnimalFactory() throws IOException {
    }

    public Animal createAnimal() {
        int randomNumberOfAnimalInList = randomNumberService.getRandomNumber(LIST_ALL_ANIMALS_IN_PROGRAM.size());
        return Animals.findAnimal(LIST_ALL_ANIMALS_IN_PROGRAM.get(randomNumberOfAnimalInList).getNameAnimal());
    }

//        private final Map<String, Function<AnimalCreationContext, Animal>> ALL_ANIMALS_MAP = Map.ofEntries(
//                Map.entry("Wolf", Wolf::new),
//                Map.entry("Bear", Bear::new),
//                Map.entry("Fox", (parameters) -> new Fox(parameters))
//
//        );
//
//
//
//        public Animal createAnimal(String keyAnimal, AnimalCreationContext parameters) throws IllegalAccessException {
//            if(!ALL_ANIMALS_MAP.containsKey(keyAnimal)) {
//                throw new IllegalAccessException();
//            }
//            Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimal);
//            return animalFunction.apply(parameters);
//        }

}
