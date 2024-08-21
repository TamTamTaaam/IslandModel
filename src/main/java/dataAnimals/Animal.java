package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import factory.AnimalCreationContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wolf.class, name = "Wolf"),
        @JsonSubTypes.Type(value = Bear.class, name = "Bear"),
        @JsonSubTypes.Type(value = Fox.class, name = "Fox"),
        @JsonSubTypes.Type(value = Snake.class, name = "Snake"),
        @JsonSubTypes.Type(value = Eagle.class, name = "Eagle"),
        @JsonSubTypes.Type(value = Horse.class, name = "Horse"),
        @JsonSubTypes.Type(value = Mouse.class, name = "Mouse"),
        @JsonSubTypes.Type(value = Rabbit.class, name = "Rabbit"),
        @JsonSubTypes.Type(value = Worm.class, name = "Worm")
})
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
