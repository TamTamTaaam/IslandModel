package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Eagle extends Animal {
    @JsonCreator
    public Eagle(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
