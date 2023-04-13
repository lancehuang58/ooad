package waterball.card;

import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardParser {

    Deck parseCard(String input) {
        Deck deck = new Deck();
        String[] cardsArray = input.split(" ");
        List<Card> cards = Arrays.stream(cardsArray)
                .map(this::parse)
                .collect(Collectors.toList());
        deck.addAll(cards);
        for (Card card : deck) {
            System.out.printf("Card.of( \"%s\", \"%s\"),\n",card.getRank().getText(), card.getSuit());
        }
        return deck;
    }

    private Card parse(String s) {
        char c = s.charAt(0);
        Suit suit = EnumUtils.getEnum(Suit.class, String.valueOf(c));
        String rankInfo = s.substring(s.indexOf("[")+1,s.indexOf("]"));
        Rank rank = Rank.fromValue(rankInfo);
        return Card.of(rank, suit);
    }
}
