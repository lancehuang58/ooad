package game.card;

import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rank {
  RANK_3(3, "3", '3'),
  RANK_4(4, "4", '4'),
  RANK_5(5, "5", '5'),
  RANK_6(6, "6", '6'),
  RANK_7(7, "7", '7'),
  RANK_8(8, "8", '8'),
  RANK_9(9, "9", '9'),
  RANK_10(10, "10", 'T'),
  RANK_J(11, "J", 'J'),
  RANK_Q(12, "Q", 'Q'),
  RANK_K(13, "K", 'K'),
  RANK_A(14, "A", 'A'),
  RANK_2(15, "2", '2');
  private final int value;
  private final String text;
  private final char signal;

  public static Rank fromValue(String s) {

    for (Rank rank : EnumSet.allOf(Rank.class)) {
      if (rank.text.equals(s)) {
        return rank;
      }
    }
    return null;
  }
}
