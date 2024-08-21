package factory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCreationContext {

   @JsonProperty
   private String name;

   @JsonProperty
   private double weight;

   @JsonProperty
   private int maxAmount;

   @JsonProperty
   private int maxSpeed;

   @JsonProperty
   private double maxSatiety;

   @JsonProperty
   private boolean canEatAnimal;

   @JsonProperty
   private boolean canBeEaten;
}
