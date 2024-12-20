package dataAnimals;

import com.fasterxml.jackson.annotation.*;
import factory.AnimalCreationContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "name")
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
public abstract class Animal extends IslandObject {

    @JsonProperty("name")
    @EqualsAndHashCode.Include
    String name;

    @JsonProperty("nameAnimal")
    @EqualsAndHashCode.Include
    String nameAnimal;

    @JsonProperty("weight")
    double weight;

    @JsonProperty("maxAmount")
    int maxAmount;

    @JsonProperty("maxSpeed")
    int maxSpeed;

    @JsonProperty("maxSatiety")
    double maxSatiety;

    @JsonProperty("chanceEatingAnimal")
    Map<String, Integer> chanceEatingAnimal;


@JsonCreator
    public Animal(AnimalCreationContext animalCreationContext) {
        this.name = animalCreationContext.getName();
        this.nameAnimal = animalCreationContext.getNameAnimal();
        this.weight = animalCreationContext.getWeight();
        this.maxAmount = animalCreationContext.getMaxAmount();
        this.maxSpeed = animalCreationContext.getMaxSpeed();
        this.maxSatiety = animalCreationContext.getMaxSatiety();
        this.chanceEatingAnimal = animalCreationContext.getChanceEatingAnimal();
    }

}
