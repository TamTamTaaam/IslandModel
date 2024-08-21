package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Bear extends Animal {
    @JsonCreator
    public Bear(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
