package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Horse extends Animal {
    @JsonCreator
    public Horse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
        this.animals=Animals.HORSE;
    }
}
