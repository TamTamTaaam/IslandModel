package dataAnimals;

import static dataAnimals.LibraryAnimal.LIST_ALL_ANIMALS_IN_PROGRAM;
import static dataAnimals.LibraryAnimal.MAP_ALL_ANIMALS_IN_PROGRAM;

public enum Animals {
    BEAR( new Bear(MAP_ALL_ANIMALS_IN_PROGRAM.get("Bear").maxSatiety)),
    EAGLE(new Eagle()),
    FOX (new Fox()),
    HORSE(new Horse()),
    MOUSE(new Mouse()),
    RABBIT(new Rabbit()),
    SNAKE(new Snake()),
    WOLF(new Wolf()),
    WORM(new Worm());

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

