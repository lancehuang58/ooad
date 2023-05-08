package game.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum Rank {
    _3(3, "3", '3'),
    _4(4, "4", '4'),
    _5(5, "5", '5'),
    _6(6, "6", '6'),
    _7(7, "7", '7'),
    _8(8, "8", '8'),
    _9(9, "9", '9'),
    _10(10, "10", 'T'),
    J(11, "J", 'J'),
    Q(12, "Q", 'Q'),
    K(13, "K", 'K'),
    A(14, "A", 'A'),
    _2(15, "2", '2');
    private final int value;
    private final String text;
    private final char signal;

    public static Rank fromValue(char c) {
        String s = String.valueOf(c);
        return fromValue(s);
    }

    public static Rank fromValue(String s) {

        for (Rank rank : EnumSet.allOf(Rank.class)) {
            if (rank.text.equals(s)) {
                return rank;
            }
        }
        return null;
    }
}
