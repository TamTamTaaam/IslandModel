package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Horse extends Animal {
    public Horse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
