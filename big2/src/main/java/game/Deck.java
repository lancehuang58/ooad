package game;

import game.card.Card;

import java.util.Stack;

public class Deck extends Stack<Card> {

    public Card deal() {
        return pop();
    }
}
