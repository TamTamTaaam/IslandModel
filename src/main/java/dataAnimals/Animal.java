package dataAnimals;

import com.fasterxml.jackson.annotation.*;
import factory.AnimalCreationContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wolf.class),
        @JsonSubTypes.Type(value = Bear.class),
        @JsonSubTypes.Type(value = Fox.class),
        @JsonSubTypes.Type(value = Snake.class),
        @JsonSubTypes.Type(value = Eagle.class),
        @JsonSubTypes.Type(value = Horse.class),
        @JsonSubTypes.Type(value = Mouse.class),
        @JsonSubTypes.Type(value = Rabbit.class),
        @JsonSubTypes.Type(value = Worm.class)
})
@Data
@NoArgsConstructor
public abstract class Animal {
    public Animals animals;

    @JsonProperty("name")
    String name;

    @JsonProperty("weight")
    double weight;

    @JsonProperty("maxAmount")
    int maxAmount;

    @JsonProperty("maxSpeed")
    int maxSpeed;

    @JsonProperty("maxSatiety")
    double maxSatiety;

    @JsonProperty("canEatAnimal")
    boolean canEatAnimal;

    @JsonProperty("canBeEaten")
    boolean canBeEaten;

@JsonCreator
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
