package waterball.card;

import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CardParser {

    public Deck parse(String input) {
        String[] cardsArray = input.split(" ");
        return new Deck(Arrays.stream(cardsArray)
                .map(this::parseEntry)
                .collect(Collectors.toList()));
    }

    private Card parseEntry(String s) {
        char c = s.charAt(0);
        Suit suit = EnumUtils.getEnum(Suit.class, String.valueOf(c));
        String rankInfo = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
        Rank rank = Rank.fromValue(rankInfo);
        return Card.of(rank, suit);
    }
}
