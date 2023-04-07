package card;

import java.util.EnumSet;

public enum Rank {
    _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), T(10), J(11), Q(12), K(13), A(14);
    private int value;

    Rank(int value) {
        this.value = value;
    }


    public static Rank fromValue(int value) {
        for (Rank rank : EnumSet.allOf(Rank.class)) {
            if (rank.value == value) {
                return rank;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
