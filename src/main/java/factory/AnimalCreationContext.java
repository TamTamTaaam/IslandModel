package factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCreationContext {
   private String name;
   private double weight;
   private int maxAmount;
   private int maxSpeed;
   private double maxSatiety;
   private boolean canEatAnimal;
   private boolean canBeEaten;
}
