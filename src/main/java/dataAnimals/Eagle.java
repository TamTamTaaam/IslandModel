package dataAnimals;

import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Eagle extends Animal {

    public Eagle(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
