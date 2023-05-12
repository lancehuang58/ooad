package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import game.card.pattern.Straight;
import java.util.List;
import java.util.stream.Collectors;

public class StraightMatcher extends PatternMatcher {

  private static final String STRAIGHT_PATTERN = "A23456789TJQK";
  private static final String STRAIGHT_PATTERN2 = "TJQKA";
  private static final String STRAIGHT_PATTERN3 = "JQKA2";
  private static final String STRAIGHT_PATTERN4 = "QKA23";
  private static final String STRAIGHT_PATTERN5 = "KA234";

  public StraightMatcher(PatternMatcher next) {
    super(next);
  }

  @Override
  protected boolean isMatch(List<Card> cards) {
    String straight =
        cards.stream()
            .sorted(Card.CARD_COMPARATOR)
            .map(Card::getRank)
            .map(rank -> String.valueOf(rank.getSignal()))
            .collect(Collectors.joining());

    return cards.size() == 5 && straightMatch(straight);
  }

  private boolean straightMatch(String straight) {
    return STRAIGHT_PATTERN.contains(straight)
        || STRAIGHT_PATTERN2.contains(straight)
        || STRAIGHT_PATTERN3.contains(straight)
        || STRAIGHT_PATTERN4.contains(straight)
        || STRAIGHT_PATTERN5.contains(straight);
  }

  @Override
  protected CardPattern buildPattern(List<Card> cards) {
    Straight pattern = new Straight();
    pattern.addAll(cards);
    return pattern;
  }
}
