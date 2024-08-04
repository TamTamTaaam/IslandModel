package factory;
import dataAnimals.Animal;
import dataAnimals.Bear;
import dataAnimals.Fox;
import dataAnimals.Wolf;
import java.util.Map;
import java.util.function.Function;

public class AnimalFactory {
   private final Map<Integer, Function<AnimalCreationContext, Animal>> ALL_ANIMALS_MAP = Map.ofEntries(
           Map.entry(1, Wolf::new),
           Map.entry(2, Bear::new),
           Map.entry(3, (parameters) -> new Fox(parameters))

   );

   public Animal createAnimal(int keyAnimal, AnimalCreationContext parameters) throws IllegalAccessException {
       if(!ALL_ANIMALS_MAP.containsKey(keyAnimal)) {
           throw new IllegalAccessException();
       }
       Function<AnimalCreationContext, Animal> animalFunction = ALL_ANIMALS_MAP.get(keyAnimal);
       return animalFunction.apply(parameters);

   }
}
