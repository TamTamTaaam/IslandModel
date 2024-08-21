package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Snake extends Animal {
    @JsonCreator
    public Snake(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
