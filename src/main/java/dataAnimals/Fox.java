package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fox extends Animal {
    @JsonCreator
    public Fox(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
