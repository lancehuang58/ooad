package waterball;

import java.util.List;
import java.util.stream.Collectors;

public class MatchMakingSystem {

    MatchStrategy strategy;

    public MatchMakingSystem(MatchStrategy strategy) {
        this.strategy = strategy;
    }

    public void matchEach(List<Individual> all) {
        for (Individual individual : all) {
            List<Individual> others = all.stream().filter(i -> !i.equals(individual)).collect(Collectors.toList());
            List<Individual> matchedPeople = strategy.match(others, individual);
            individual.setMatchedIndividual(matchedPeople.get(0));
        }
    }
}
