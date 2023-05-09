package game.card.pattern;

public class Single extends CardPattern {

  public Single() {
    super(CardPatternType.SINGLE);
  }

  @Override
  public String getName() {
    return "Single";
  }
}
