package game;


import game.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CardPattern extends ArrayList<Card> implements Comparable<CardPattern>{

    private CardPatternType cardPatternType;

    public static CardPattern getPattern() {
        return null;
    }

    @Override
    public int compareTo(CardPattern o) {
        return 0;
    }
}
