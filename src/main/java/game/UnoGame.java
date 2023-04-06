package game;

import java.util.List;

public class UnoGame implements Game {
    AbstractDeck deck;
    @Override
    public Player contest(List<Player> players) {
        return null;
    }

    @Override
    public AbstractDeck createDeck() {
        deck = new UnoDeck();
        return deck;
    }
}
