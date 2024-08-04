package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Wolf extends Animal {
    public Wolf(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
