package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Rabbit extends Animal {
    public Rabbit(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
