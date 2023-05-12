package game.card;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;

@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = {"rank", "suit"})
public class Card implements Comparable<Card> {
  public static final Comparator<Card> CARD_COMPARATOR =
      Comparator.comparing(Card::getRank).thenComparing(Card::getSuit);
  private Rank rank;
  private Suit suit;

  @Override
  public String toString() {
    return String.format("%s[%s]", suit.name(), rank.getText());
  }

  @Override
  public int compareTo(Card o) {
    return CARD_COMPARATOR.compare(this, o);
  }
}
