package dataAnimals;

import island.IslandParameters;
import services.ReadFileService;

import java.util.List;
import java.util.Map;

public class AnimalLibrary {
    private static final ReadFileService READ_FILE_SERVICE;
    public static final Map<String, Animal> MAP_ALL_ANIMALS_IN_PROGRAM;
    public static final List<String> LIST_ALL_ANIMALS_IN_PROGRAM;
    public static final Plant PLANT;
    public static final IslandParameters ISLAND_PARAMETERS;

    static {
        try {
            READ_FILE_SERVICE = new ReadFileService();
            MAP_ALL_ANIMALS_IN_PROGRAM = READ_FILE_SERVICE.readMapAllAnimals();
            LIST_ALL_ANIMALS_IN_PROGRAM =  READ_FILE_SERVICE.createListAnimals(MAP_ALL_ANIMALS_IN_PROGRAM);
            PLANT = READ_FILE_SERVICE.readPlant();
            ISLAND_PARAMETERS = READ_FILE_SERVICE.readCoordinates();
        } catch (Exception e) {
            System.out.println("Ошибка ReadFileService");
            throw new RuntimeException(e);
        }
    }
    
}
