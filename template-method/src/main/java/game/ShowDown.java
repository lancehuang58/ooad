package game;

import card.ShowDownCard;
import deck.Deck;
import deck.ShowdownDeck;
import lombok.extern.slf4j.Slf4j;
import player.Player;

import java.util.Comparator;
import java.util.NoSuchElementException;

@Slf4j
public class ShowDown extends Game<ShowDownCard> {

    Deck<ShowDownCard> deck;

    public Deck<ShowDownCard> createDeck() {
        this.deck = new ShowdownDeck(52);
        return deck;
    }

    public Player<ShowDownCard> contest() {
        for (int i = 0; i < 13; i++) {
            Player<ShowDownCard> winner = null;
            ShowDownCard winCard = null;
            for (Player<ShowDownCard> player : players) {
                ShowDownCard card = player.showCard();
                if (winner == null) {
                    winCard = card;
                    winner = player;
                } else {
                    boolean result = winCard.compareTo(card) > 0;
                    winCard = result ? winCard : card;
                    winner = result ? winner : player;
                }
            }
            if (winner != null) {
                log.info("round {}, winner is {}", i + 1, winner.getName());
                winner.scoreIncremental();
            }
        }
        return players.stream().max(Comparator.comparing(Player::getScore)).orElseThrow(NoSuchElementException::new);
    }


    public void dispatchCards() {
        for (Player<ShowDownCard> player : players) {
            for (int i = 0; i < 13; i++) {
                ShowDownCard card = deck.drawCard();
                player.addCard(card);
            }
        }
    }

}
