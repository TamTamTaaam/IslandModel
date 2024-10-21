package island;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class IslandParameters {

    @JsonProperty("x")
    private final Integer coordinateX;

    @JsonProperty("y")
    private final Integer coordinateY;

    @JsonProperty("countAnimals")
    private final Integer countAnimals;

    public IslandParameters(@JsonProperty("x") Integer x,
                            @JsonProperty("y") Integer y,
                            @JsonProperty("countAnimals") Integer count) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.countAnimals = count;
    }
}
