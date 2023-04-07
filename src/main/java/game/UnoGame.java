package game;

import java.util.List;

public class UnoGame implements Game {
    AbstractDeck deck;

    @Override
    public Player contest(List<Player> players) {
        Player winner = null;
        Card card = deck.drawCard();
        for (Player player : players) {
            card = compareAndReplace(card, player);
            if (player.getHand().size() == 0) {
                winner = player;
                break;
            }
        }

        return winner;
    }

    private Card compareAndReplace(Card card, Player player) {
        boolean matchResult = player.match(card);
        if (!matchResult) {
            if (deck.isEmpty()) {
                deck.shuffleExcept(card);
            }
            player.getHand().add(deck.drawCard());
        }
        return card;
    }

    @Override
    public AbstractDeck createDeck() {
        deck = new UnoDeck();
        return deck;
    }
}
