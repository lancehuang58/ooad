package game;


import game.card.Card;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = false)
public class CardPattern extends ArrayList<Card> {

    private CardPatternType cardPatternType;
}
