package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Mouse extends Animal {
    @JsonCreator
    public Mouse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
