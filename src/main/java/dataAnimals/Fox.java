package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data

public class Fox extends Animal {
    public Fox(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
