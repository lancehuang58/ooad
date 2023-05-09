package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import game.card.pattern.TwoPair;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPairMatcher extends PatternMatcher {

  public TwoPairMatcher(PatternMatcher next) {
    super(next);
  }

  @Override
  protected boolean isMatch(List<Card> cards) {
    return cards.size() == 2 && sameRank(cards);
  }

  private boolean sameRank(List<Card> cards) {
    return cards.stream().map(Card::getRank).collect(Collectors.toSet()).size() == 1;
  }

  @Override
  protected CardPattern buildPattern(List<Card> cards) {
    TwoPair pattern = new TwoPair();
    pattern.addAll(cards);
    return pattern;
  }
}
