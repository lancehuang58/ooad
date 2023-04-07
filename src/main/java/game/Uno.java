package game;

import card.UnoCard;
import deck.UnoDeck;
import player.Player;

public class Uno extends Game<UnoCard> {

    UnoDeck deck;

    public UnoDeck createDeck() {
        deck = new UnoDeck(40);
        return deck;
    }

    @Override
    public void dispatchCards() {
        for (Player<UnoCard> player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCard(deck.drawCard());
            }
        }
    }

    @Override
    public Player<UnoCard> contest() {
        return null;
    }


}
