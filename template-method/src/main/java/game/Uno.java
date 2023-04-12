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
        Player<UnoCard> winner = null;
        UnoCard currentCard = deck.drawCard();

        for (Player<UnoCard> player : players) {
            currentCard = compareAndReplace(currentCard, player);
            if (player.getHand().isEmpty()) {
                winner = player;
                break;
            }
        }

        return winner;
    }

    private UnoCard compareAndReplace(UnoCard currentCard, Player<UnoCard> player) {
        UnoCard playerCard = player.showCard();
        boolean matchResult = match(playerCard, currentCard);
        if (matchResult) {
            return playerCard;
        } else {
            player.addCard(playerCard);

            if (deck.isEmpty()) {
                deck.shuffleExcept(currentCard);
            }

            player.addCard(deck.drawCard());
            return currentCard;
        }
    }

    private boolean match(UnoCard playerCard, UnoCard currentCard) {
        if (playerCard.getColor() == currentCard.getColor() ||
                playerCard.getNumber() == currentCard.getNumber()) {
            return true;
        }
        return false;
    }
}
