package game;


import game.card.Card;
import lombok.Data;

import java.util.List;
@Data
public class CardPattern {

	private CardPatternType cardPatternType;

	private List<Card> cards;

}
