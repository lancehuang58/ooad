package game;

import java.util.Comparator;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    Comparator<Card> comparator =
            Comparator
                    .comparing(Card::getRank)
                    .thenComparing(Card::getSuit)
                    .reversed();


    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        return comparator.compare(this, o);
    }
}
