package waterball;

import java.util.List;

public interface MatchStrategy {
    List<Individual> match(List<Individual> others, Individual i);
}
