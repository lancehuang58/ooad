package game;

import game.card.Card;
import game.card.Suit;
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

    public CardPattern play() {
        return null;
    }

    public void addCard(Card card) {
        this.handCard.add(card);
    }

    public void sortHandCards() {
        Collections.sort(handCard);
    }

    public void printCards() {
        log.info("{} - {}", name, handCard.stream().map(Card::toString).collect(joining("\t")));
    }

    public CardPattern deal(int[] input) {
        CardPattern cardPattern = new CardPattern();
        for (int i = 0; i < input.length; i++) {
            cardPattern.add(this.handCard.get(i));
        }
        handCard.removeAll(cardPattern);
        return cardPattern;
    }

    public boolean haveC3() {
        return handCard.stream()
                .anyMatch(card -> card.getRank().getValue() == 3
                && card.getSuit().equals(Suit.C));
    }
}
