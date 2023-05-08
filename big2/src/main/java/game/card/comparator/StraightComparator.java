package game.card.comparator;

import game.card.Card;
import game.card.pattern.CardPattern;

import java.util.Comparator;

public class StraightComparator implements Comparator<CardPattern> {
    @Override
    public int compare(CardPattern o1, CardPattern o2) {
        return Card.CARD_COMPARATOR.compare(o1.getMaxOne(), o2.getMaxOne());
    }
}
