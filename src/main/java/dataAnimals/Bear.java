package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Bear extends Animal {
    public Bear(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
