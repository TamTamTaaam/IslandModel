package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Worm extends Animal {
    @JsonCreator
    public Worm(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
