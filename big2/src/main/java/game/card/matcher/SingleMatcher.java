package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import game.card.pattern.Single;

import java.util.List;

public class SingleMatcher extends PatternMatcher {

    @Override
    protected boolean isMatch(List<Card> cards) {
        return cards.size() == 1;
    }

    @Override
    protected CardPattern buildPattern(List<Card> cards) {
        Single pattern = new Single();
        pattern.addAll(cards);
        return pattern;
    }

    public SingleMatcher(PatternMatcher next) {
        super(next);
    }
}
