package dataAnimals;

import services.ReadAnimalsService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LibraryAnimal {
    private static final ReadAnimalsService readAnimalsService = new ReadAnimalsService();
    public static final List<Animal> LIST_ALL_ANIMALS_IN_PROGRAM;
    public static final Map<String, Animal> MAP_ALL_ANIMALS_IN_PROGRAM;

    static {
        try {
            LIST_ALL_ANIMALS_IN_PROGRAM = readAnimalsService.getListAllAnimals();
            MAP_ALL_ANIMALS_IN_PROGRAM = readAnimalsService.getMapAllAnimals();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
