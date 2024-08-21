package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data

public class Fox extends Animal {
    @JsonCreator
    public Fox(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
