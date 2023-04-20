package waterball;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HabitBaseStrategy implements MatchStrategy {

    @Override
    public List<Individual> match(List<Individual> others, Individual i) {
        Comparator<Individual> comparing = Comparator.<Individual, Integer>comparing(individual -> individual.habitDiffCount(i)).reversed();
        return others.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
    }
}
