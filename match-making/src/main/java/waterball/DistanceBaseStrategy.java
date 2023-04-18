package waterball;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceBaseStrategy implements MatchStrategy {

    @Override
    public List<Individual> match(List<Individual> others, Individual i) {
        return others.stream()
                .sorted(Comparator.comparing(idv -> idv.getCoord().distance(i.getCoord())))
                .collect(Collectors.toList());
    }
}
