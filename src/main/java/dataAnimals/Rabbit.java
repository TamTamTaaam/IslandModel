package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rabbit extends Animal {
    @JsonCreator
    public Rabbit(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
        this.animals=Animals.RABBIT;
    }
}
