package game.card;

import game.card.matcher.*;
import game.card.pattern.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CardPatternParser {

    public static final String CARD_SPLITTER = " ";

    private final PatternMatcher matcher = new SingleMatcher(new TwoPairMatcher(new StraightMatcher(new FullHouseMatcher(null))));

    public CardPattern parse(String input, List<Card> handCard) {

        String[] cardsIndexString = input.split(CARD_SPLITTER);
        int[] cardsIndexes = Arrays.stream(cardsIndexString).filter(Objects::nonNull)
                .mapToInt(Integer::parseInt).toArray();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < cardsIndexes.length; i++) {
            Card card = handCard.get(cardsIndexes[i]);
            cards.add(card);
            handCard.remove(card);
        }
        return matcher.match(cards);
    }
}
