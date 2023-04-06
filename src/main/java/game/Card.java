package game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@ToString
@Getter
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;
    private Color color;
    private Integer number;

    public static Card of(Rank rank, Suit suit) {
        return new Card(rank, suit, null, null);
    }

    public static Card of(Color color, Integer number) {
        return new Card(null, null, color, number);
    }

    static Comparator<Card> comparator = Comparator.comparing(Card::rankValue).thenComparing(Card::getSuit);

    public int rankValue() {
        return rank.getValue();
    }

    @Override
    public int compareTo(Card o) {
        return comparator.compare(this, o);
    }
}
