package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Mouse extends Animal implements Herbivore {
    @JsonCreator
    public Mouse(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
