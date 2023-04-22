package game;

import game.card.Card;
import game.card.Rank;
import game.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 2; i < 15; i++) {
            EnumSet<Suit> suits = EnumSet.allOf(Suit.class);
            for (Suit suit : suits) {
                cards.add(Card.of(Rank.fromValue(i), suit));
            }
        }
    }


    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
