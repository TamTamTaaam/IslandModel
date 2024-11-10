package dataAnimals;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Plant extends IslandObject {
    @JsonProperty("weight")
    private double weight;

    @JsonProperty("maxAmount")
    private int maxAmount;

    @JsonCreator
    public Plant(
                 @JsonProperty("weight") double weight,
                 @JsonProperty("maxAmount") int maxAmount
    ) {
        this.weight = weight;
        this.maxAmount = maxAmount;
    }
    public String toString() {
        return "Plant()";
    }
}
