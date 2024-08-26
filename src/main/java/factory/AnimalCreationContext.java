package factory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dataAnimals.*;
import lombok.Data;

@Data
public class AnimalCreationContext {

   @JsonProperty("name")
   private String name;

   @JsonProperty("weight")
   private double weight;

   @JsonProperty("maxAmount")
   private int maxAmount;

   @JsonProperty("maxSpeed")
   private int maxSpeed;

   @JsonProperty("maxSatiety")
   private double maxSatiety;

   @JsonProperty("canEatAnimal")
   private boolean canEatAnimal;

   @JsonProperty("canBeEaten")
   private boolean canBeEaten;

   @JsonCreator
   public AnimalCreationContext(
           @JsonProperty("name") String name,
           @JsonProperty("weight") double weight,
           @JsonProperty("maxAmount") int maxAmount,
           @JsonProperty("maxSpeed") int maxSpeed,
           @JsonProperty("maxSatiety") double maxSatiety,
           @JsonProperty("canEatAnimal") boolean canEatAnimal,
           @JsonProperty("canBeEaten") boolean canBeEaten
   ) {
      this.name = name;
      this.weight = weight;
      this.maxAmount = maxAmount;
      this.maxSpeed = maxSpeed;
      this.maxSatiety = maxSatiety;
      this.canEatAnimal = canEatAnimal;
      this.canBeEaten = canBeEaten;
   }
}

