package game.card.matcher;

import game.card.Card;
import game.card.Rank;
import game.card.pattern.CardPattern;
import game.card.pattern.Straight;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StraightMatcher extends PatternMatcher {

    private final static String straightPattern = "A23456789TJQK";
    private final static String straightPattern2 = "TJQKA";
    private final static String straightPattern3 = "JQKA2";
    private final static String straightPattern4 = "QKA23";
    private final static String straightPattern5 = "KA234";

    @Override
    protected boolean isMatch(List<Card> cards) {
        String straight = cards.stream().sorted(Card.CARD_COMPARATOR).map(Card::getRank).map(rank -> String.valueOf(rank.getSignal())).collect(Collectors.joining());


        return cards.size() == 5 && straightMatch(straight);
    }

    private boolean straightMatch(String straight) {
        return straightPattern.contains(straight) || straightPattern2.contains(straight) || straightPattern3.contains(straight) || straightPattern4.contains(straight) || straightPattern5.contains(straight);
    }

    @Override
    protected CardPattern buildPattern(List<Card> cards) {
        Straight pattern = new Straight();
        pattern.addAll(cards);
        return pattern;
    }

    public StraightMatcher(PatternMatcher next) {
        super(next);
    }
}
