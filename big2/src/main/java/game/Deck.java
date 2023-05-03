package game;

import game.card.Card;
import game.card.Rank;
import game.card.Suit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
@Slf4j
public class Deck extends Stack<Card> {

    public Deck(String inputCardString) {
        log.info("input data for deck {}", inputCardString);
        parse(inputCardString);
    }

    public Card deal() {
        return pop();
    }

    private void parse(String input) {
        String[] cardsArray = input.split(" ");
        Arrays.stream(cardsArray)
                .map(this::parseInputCard)
                .collect(Collectors.toList())
                .forEach(this::push);
    }

    private Card parseInputCard(String s) {
        char c = s.charAt(0);
        Suit suit = EnumUtils.getEnum(Suit.class, String.valueOf(c));
        String rankInfo = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
        Rank rank = Rank.fromValue(rankInfo);
        return Card.of(rank, suit);
    }
}
