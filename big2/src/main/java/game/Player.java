package game;

import game.card.Card;
import game.card.CardPatternParser;
import game.card.Suit;
import game.card.pattern.CardPattern;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

import static java.util.stream.Collectors.joining;

@Slf4j
@Getter
public class Player {

    private final int index;
    private final String name;
    private static int i = 0;
    private final HandCards handCard;

    public Player(String name) {
        this.name = name;
        this.index = i++;
        this.handCard = new HandCards();
    }


    public void addCard(Card card) {
        this.handCard.add(card);
    }

    public void sortHandCards() {
        Collections.sort(handCard);
    }

    public void printHandCards() {
        System.out.printf("%s\n", handCard.stream().map(Card::toString).collect(joining(" ")));
    }

    public CardPattern deal(String input) {
        return new CardPatternParser().parse(input, handCard);
    }

    public boolean haveC3() {
        return handCard.stream()
                .anyMatch(card -> card.getRank().getValue() == 3
                        && card.getSuit().equals(Suit.C));
    }

    public boolean isWinner() {
        return handCard.isEmpty();
    }
}
