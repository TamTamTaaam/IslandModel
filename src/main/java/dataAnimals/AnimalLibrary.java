package dataAnimals;

import services.ReadAnimalsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnimalLibrary {
    private static final ReadAnimalsService readAnimalsService = new ReadAnimalsService();
    public static final Map<String, Animal> MAP_ALL_ANIMALS_IN_PROGRAM;
    public static final List<String> LIST_ALL_ANIMALS_IN_PROGRAM;

    static {
        try {

            MAP_ALL_ANIMALS_IN_PROGRAM = readAnimalsService.getMapAllAnimals();
            LIST_ALL_ANIMALS_IN_PROGRAM =  readAnimalsService.createListAnimals(MAP_ALL_ANIMALS_IN_PROGRAM);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
