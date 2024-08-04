package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Mouse extends Animal {
    public Mouse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
