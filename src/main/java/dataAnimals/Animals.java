package dataAnimals;

import factory.AnimalCreationContext;
import services.ReadAnimalsService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/*
import static dataAnimals.AnimalLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;*/

public enum Animals {
    BEAR(new Bear()),
    EAGLE(new Eagle()),
    FOX (new Fox()),
    HORSE(new Horse()),
    MOUSE(new Mouse()),
    RABBIT(new Rabbit()),
    SNAKE(new Snake()),
    WOLF(new Wolf()),
    WORM(new Worm());

//    BEAR( new Bear(MAP_ALL_ANIMALS_IN_PROGRAM.get("Bear").maxSatiety)),
//    EAGLE(new Eagle(MAP_ALL_ANIMALS_IN_PROGRAM.get("Eagle").maxSatiety)),
//    FOX (new Fox(MAP_ALL_ANIMALS_IN_PROGRAM.get("Fox").maxSatiety)),
//    HORSE(new Horse(MAP_ALL_ANIMALS_IN_PROGRAM.get("Horse").maxSatiety)),
//    MOUSE(new Mouse(MAP_ALL_ANIMALS_IN_PROGRAM.get("Mouse").maxSatiety)),
//    RABBIT(new Rabbit(MAP_ALL_ANIMALS_IN_PROGRAM.get("Rabbit").maxSatiety)),
//    SNAKE(new Snake(MAP_ALL_ANIMALS_IN_PROGRAM.get("Snake").maxSatiety)),
//    WOLF(new Wolf(MAP_ALL_ANIMALS_IN_PROGRAM.get("Wolf").maxSatiety)),
//    WORM(new Worm(MAP_ALL_ANIMALS_IN_PROGRAM.get("Worm").maxSatiety));
    private final Animal animal;

    Animals(Animal animal) {
        this.animal = animal;
    }
    public static Animal findAnimal(String animalName) {
        try {
            Animals value = Animals.valueOf(animalName.toUpperCase());
            return value.animal;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("not found" + animalName, e);
        }
    }

}

