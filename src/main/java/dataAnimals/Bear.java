package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bear extends Animal {
    @JsonCreator
    public Bear(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
        this.animals=Animals.BEAR;
    }

}
