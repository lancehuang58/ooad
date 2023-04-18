package waterball;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HabitBaseStrategy implements MatchStrategy {

    @Override
    public List<Individual> match(List<Individual> others, Individual i) {
        return others.stream()
                .sorted(Comparator.comparing(individual-> individual.habitDiffCount(i)))
                .collect(Collectors.toList());
    }
}
