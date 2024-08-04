import dataAnimals.*;
import factory.AnimalCreationContext;

public enum Animals {
    BEAR( new Bear(new AnimalCreationContext())),
    EAGLE(new Eagle(new AnimalCreationContext())),
    FOX (new Fox(new AnimalCreationContext())),
    HORSE(new Horse(new AnimalCreationContext())),
    MOUSE(new Mouse(new AnimalCreationContext())),
    RABBIT(new Rabbit(new AnimalCreationContext())),
    SNAKE(new Snake(new AnimalCreationContext())),
    WOLF(new Wolf(new AnimalCreationContext())),
    WORM(new Worm(new AnimalCreationContext()));


    private final Animal animal;

    Animals(Animal animal) {
        this.animal = animal;
    }
    public Animal findAnimal(String animalName) {
        try {
            Animals value = Animals.valueOf(animalName.toUpperCase());
            return value.animal;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("not found" + animalName, e);
        }
    }

}
