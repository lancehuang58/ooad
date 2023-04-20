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
            System.out.println("### individual.. "+ individual);
            List<Individual> others = all.stream().filter(i -> !i.equals(individual)).collect(Collectors.toList());
            List<Individual> matchedPeople = strategy.match(others, individual);
            for (Individual matchedPerson : matchedPeople) {
                System.out.println(">>> matched ... "+matchedPerson);
            }
            individual.setMatchedIndividual(matchedPeople.get(0));
        }
    }
}
