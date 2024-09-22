package dataAnimals;

public enum Animals {
    BEAR( new Bear()),
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
    public Animal findAnimal(String animalName) {
        try {
            Animals value = Animals.valueOf(animalName.toUpperCase());
            return value.animal;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("not found" + animalName, e);
        }
    }

}

