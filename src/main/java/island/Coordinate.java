package island;

import lombok.Data;

@Data
public class Coordinate {
    public Integer x;
    public Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}