import dataAnimals.*;
import factory.AnimalFactory;
import services.CreatingIslandService;
import services.ReadFileService;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("hello hello");
        AnimalFactory animalFactory = new AnimalFactory();
       System.out.println(AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM);

        for (int i = 0; i < 4; i++) {
            Animal animal = animalFactory.createAnimal();
            System.out.println(animal + " " + animal.getMaxSatiety());
        }
        ReadFileService readFileService = new ReadFileService();

        CreatingIslandService creatingIslandService = new CreatingIslandService();
        System.out.println(creatingIslandService.ISLAND_PARAMETERS);









    }
}
