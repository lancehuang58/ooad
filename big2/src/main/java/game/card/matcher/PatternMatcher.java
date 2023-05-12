package game.card.matcher;

import game.card.Card;
import game.card.pattern.CardPattern;
import game.card.pattern.Null;
import java.util.List;

public abstract class PatternMatcher {

  private static final Null nullPattern = new Null();

  private final PatternMatcher next;

  protected PatternMatcher(PatternMatcher next) {
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
    return nullPattern;
  }
}
