package factory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class AnimalCreationContext {

   @JsonProperty("name")
   private String name;

   @JsonProperty("nameAnimal")
   private String nameAnimal;

   @JsonProperty("weight")
   private double weight;

   @JsonProperty("maxAmount")
   private int maxAmount;

   @JsonProperty("maxSpeed")
   private int maxSpeed;

   @JsonProperty("maxSatiety")
   private double maxSatiety;

   @JsonProperty("chanceEatingAnimal")
   private Map<String, Integer> chanceEatingAnimal;

   @JsonCreator
   public AnimalCreationContext(
           @JsonProperty("name") String name,
           @JsonProperty("nameAnimal") String nameAnimal,
           @JsonProperty("weight") double weight,
           @JsonProperty("maxAmount") int maxAmount,
           @JsonProperty("maxSpeed") int maxSpeed,
           @JsonProperty("maxSatiety") double maxSatiety,
           @JsonProperty("chanceEatingAnimal") Map<String, Integer> chanceEatingAnimal
   ) {
      this.name = name;
      this.nameAnimal = nameAnimal;
      this.weight = weight;
      this.maxAmount = maxAmount;
      this.maxSpeed = maxSpeed;
      this.maxSatiety = maxSatiety;
      this.chanceEatingAnimal = chanceEatingAnimal;
   }
}


