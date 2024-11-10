package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Worm extends Animal {
    @JsonCreator
    public Worm(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
