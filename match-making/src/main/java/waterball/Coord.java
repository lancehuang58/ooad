package waterball;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@AllArgsConstructor
public class Coord {
    int x;
    int y;

    public double distance(Coord coord) {
        return Math.pow(Math.sqrt(coord.x - x) + Math.sqrt(coord.y - y), 0.5);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("x", x)
                .append("y", y)
                .toString();
    }
}
