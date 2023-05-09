package game.card.pattern;

public class Straight extends CardPattern {
  public Straight() {
    super(CardPatternType.STRAIGHT);
  }

  @Override
  public String getName() {
    return "Straight";
  }
}
