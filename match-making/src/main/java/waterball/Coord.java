package waterball;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coord {
    int x;
    int y;

    public double distance(Coord coord) {
        return Math.pow(Math.sqrt(coord.x - x) + Math.sqrt(coord.y - y), 0.5);
    }
}
