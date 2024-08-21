package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Rabbit extends Animal {
    @JsonCreator
    public Rabbit(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
