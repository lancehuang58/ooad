package game.card;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor(staticName = "of")
public class Card {

    private Rank rank;
    private Suit suit;

    public static Comparator<Card> cardComparator = Comparator
            .comparing(Card::getRankValue)
            .thenComparing(Card::getSuitValue).reversed();

    @Override
    public String toString() {
        return String.format("[%d]%s", rank.getValue(), suit.name());
    }

    public int compare(Card card) {
        return cardComparator.compare(this, card);
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public int getSuitValue() {
        return suit.getSuitValue();
    }

}
