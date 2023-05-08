package game.card;

import game.CardPattern;
import game.CardPatternType;

import java.util.Arrays;
import java.util.List;

public class CardPatternParser {

    public static final String CARD_SPLITTER = " ";

    public CardPattern parse(String input, List<Card> cards) {
        CardPattern cardPattern = null;
        String[] cardsIndexString = input.split(CARD_SPLITTER);
        int[] cardsIndexes = Arrays.stream(cardsIndexString).mapToInt(Integer::parseInt).toArray();
        if (cardsIndexes.length == 1) {
            cardPattern = new CardPattern(CardPatternType.SINGLE);
            for (int i = 0; i < cardsIndexes.length; i++) {
                cardPattern.add(cards.remove(cardsIndexes[i]));
            }
        }
        return cardPattern;
    }
}
