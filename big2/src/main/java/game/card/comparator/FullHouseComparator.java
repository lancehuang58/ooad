package game.card.comparator;

import game.card.Card;
import game.card.pattern.CardPattern;

import java.util.Comparator;

public class FullHouseComparator implements Comparator<CardPattern> {
    @Override
    public int compare(CardPattern o1, CardPattern o2) {
        return Card.CARD_COMPARATOR.compare(o1.getMaxOfThree(), o2.getMaxOfThree());
    }
}
