package game.card;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;

import java.util.Comparator;


@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = {"rank", "suit"})
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    @Override
    public String toString() {
        return String.format("%s[%s]", suit.name(), rank.getText());
    }

    static Comparator<Card> comparator = Comparator
            .comparing(Card::getRank)
            .thenComparing(Card::getSuit);

    public static Card of(String r, String s) {
        return new Card(Rank.fromValue(r), EnumUtils.getEnum(Suit.class, s));
    }

    @Override
    public int compareTo(Card o) {
        return comparator.compare(this, o);
    }
}
