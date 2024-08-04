package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Snake extends Animal {
    public Snake(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
