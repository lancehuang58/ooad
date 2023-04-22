package game.card;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum Rank {
    _2(2), _3(3), _4(4), _5(5), _6(6),
    _7(7), _8(8), _9(9), _10(10), J(11),
    Q(12), K(13), A(14);

    private int value;

    public static Rank fromValue(int v) {
        EnumSet<Rank> ranks = EnumSet.allOf(Rank.class);
        for (Rank rank : ranks) {
            if (rank.value == v) {
                return rank;
            }
        }
        return null;
    }

    Rank(int value) {
        this.value = value;
    }
}
