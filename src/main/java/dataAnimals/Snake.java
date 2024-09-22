package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Snake extends Animal {
    @JsonCreator
    public Snake(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
        this.animals=Animals.SNAKE;
    }
}
