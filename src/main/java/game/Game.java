package game;

import java.util.ArrayList;
import java.util.List;

public interface Game {

    default List<Player> initPlayers(int size) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            players.add(new AIPlayer());
        }
        return players;
    }

    Player contest(List<Player> players);

    default void playerDrawCard(List<Player> players, AbstractDeck deck, int times) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < times; j++) {
                Player player = players.get(i);
                player.addCard(deck.drawCard());
            }
        }
    }

    AbstractDeck createDeck();
}
