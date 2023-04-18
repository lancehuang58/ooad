package waterball;

import java.util.Collections;
import java.util.List;

public class ReverseStrategy implements MatchStrategy {

    private final MatchStrategy next;

    public ReverseStrategy(MatchStrategy next) {
        this.next = next;
    }


    @Override
    public List<Individual> match(List<Individual> others, Individual i) {
        List<Individual> matched = next.match(others, i);
        Collections.reverse(matched);
        return matched;
    }
}
