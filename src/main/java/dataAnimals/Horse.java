package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Horse extends Animal {
    @JsonCreator
    public Horse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
