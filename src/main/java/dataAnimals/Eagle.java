package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Eagle extends Animal {
    @JsonCreator
    public Eagle(AnimalCreationContext animalCreationContext) {
        super(animalCreationContext);
    }
}
