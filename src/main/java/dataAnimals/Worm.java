package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Worm extends Animal {
    @JsonCreator
    public Worm(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
        this.animals=Animals.WORM;
    }
}
