package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import factory.AnimalCreationContext;
import lombok.Data;

@Data
public class Wolf extends Animal {
    @JsonCreator
    public Wolf(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
