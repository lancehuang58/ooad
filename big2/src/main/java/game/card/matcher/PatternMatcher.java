package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import java.util.List;

public abstract class PatternMatcher {

  private final PatternMatcher next;

  public PatternMatcher(PatternMatcher next) {
    this.next = next;
  }

  protected abstract boolean isMatch(List<Card> cards);

  protected abstract CardPattern buildPattern(List<Card> cards);

  public CardPattern match(List<Card> input) {
    if (isMatch(input)) {
      return buildPattern(input);
    } else {
      if (next != null) {
        return next.match(input);
      }
    }
    return null;
  }
}
