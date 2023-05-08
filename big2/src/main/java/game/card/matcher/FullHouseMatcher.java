package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import game.card.pattern.FullHouse;

import java.util.List;
import java.util.stream.Collectors;

public class FullHouseMatcher extends PatternMatcher {
    @Override
    protected boolean isMatch(List<Card> cards) {
        return cards.size() == 5 && twoSuit(cards);
    }

    private boolean twoSuit(List<Card> cards) {
        return cards.stream().collect(Collectors.groupingBy(Card::getRank)).size() == 2;
    }

    @Override
    protected CardPattern buildPattern(List<Card> cards) {
        FullHouse pattern = new FullHouse();
        pattern.addAll(cards);
        return pattern;
    }

    public FullHouseMatcher(PatternMatcher next) {
        super(next);
    }
}
