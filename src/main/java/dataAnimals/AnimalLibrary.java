package dataAnimals;

import services.ReadFileService;

import java.util.List;
import java.util.Map;

public class AnimalLibrary {
    private static final ReadFileService READ_FILE_SERVICE = new ReadFileService();
    public static final Map<String, Animal> MAP_ALL_ANIMALS_IN_PROGRAM;
    public static final List<String> LIST_ALL_ANIMALS_IN_PROGRAM;

    static {
        try {

            MAP_ALL_ANIMALS_IN_PROGRAM = READ_FILE_SERVICE.getMapAllAnimals();
            LIST_ALL_ANIMALS_IN_PROGRAM =  READ_FILE_SERVICE.createListAnimals(MAP_ALL_ANIMALS_IN_PROGRAM);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
