package dataAnimals;

import com.fasterxml.jackson.annotation.JsonProperty;
import factory.AnimalCreationContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {
    @JsonProperty
    String name;

    @JsonProperty
    double weight;

    @JsonProperty
    int maxAmount;

    @JsonProperty
    int maxSpeed;

    @JsonProperty
    double maxSatiety;

    @JsonProperty
    boolean canEatAnimal;

    @JsonProperty
    boolean canBeEaten;

    public Animal(AnimalCreationContext animalCreationContext) {
        this.name = animalCreationContext.getName();
        this.weight = animalCreationContext.getWeight();
        this.maxAmount = animalCreationContext.getMaxAmount();
        this.maxSpeed = animalCreationContext.getMaxSpeed();
        this.maxSatiety = animalCreationContext.getMaxSatiety();
        this.canEatAnimal = animalCreationContext.isCanEatAnimal();
        this.canBeEaten = animalCreationContext.isCanBeEaten();
    }

}
