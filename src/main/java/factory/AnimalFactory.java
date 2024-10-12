package factory;
import dataAnimals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class AnimalFactory {

    private final Map<String, Function<AnimalCreationContext, Animal>> ALL_ANIMALS_MAP = Map.ofEntries(
           Map.entry("Wolf", Wolf::new),
           Map.entry("Bear", Bear::new),
           Map.entry("Fox", (parameters) -> new Fox(parameters))

   );

   public Animal createAnimal(String keyAnimal, AnimalCreationContext parameters) throws IllegalAccessException {
       if(!ALL_ANIMALS_MAP.containsKey(keyAnimal)) {
           throw new IllegalAccessException();
       }
       Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimal);
       return animalFunction.apply(parameters);

   }

}
