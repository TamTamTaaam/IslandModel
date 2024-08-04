package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Worm extends Animal {
    public Worm(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
