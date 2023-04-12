package card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;
@ToString
@AllArgsConstructor
@Getter
public class ShowDownCard implements Card, Comparable<ShowDownCard> {

    private Rank rank;

    private Suit suit;

    static Comparator<ShowDownCard> comparator =
            Comparator.comparing(ShowDownCard::rankValue)
                    .thenComparing(ShowDownCard::getSuit);

    public int rankValue() {
        return rank.getValue();
    }

    @Override
    public int compareTo(ShowDownCard o) {
        return comparator.compare(this, o);
    }

}
