package game;

import game.player.AiPlayer;
import game.player.RealPlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Showdown {

    private List<Player> players;

    private Deck deck;

    public void play() {
        deck = new Deck();
        deck.shuffle();
        playerInit();
        playerDrawCards();
        Player winner = turnsStart();
        System.out.println("winner is " + winner.getName());
    }

    private void playerInit() {
        players = new ArrayList<>();
        players.add(new RealPlayer());
        players.add(new RealPlayer());
        players.add(new AiPlayer());
        players.add(new AiPlayer());
    }

    private void playerDrawCards() {
        for (int i = 0; i < 13; i++) {
            for (int y = 0; y < players.size(); y++) {
                players.get(y).addCard(deck.drawCard());
            }
        }
    }


    private Player turnsStart() {
        for (int i = 0; i < 13; i++) {
            Card winnerCard = null;
            Player winnerPlayer = null;
            for (int y = 0; y < players.size(); y++) {
                Player currentPlayer = players.get(y);
                Card currentCard = currentPlayer.showCard();
                if (winnerCard != null) {
                    winnerCard = winnerCard.compareTo(currentCard) > 0 ? winnerCard : currentCard;
                    winnerPlayer = winnerCard.compareTo(currentCard) > 0 ? winnerPlayer : currentPlayer;
                } else {
                    winnerCard = currentCard;
                    winnerPlayer = currentPlayer;
                }
                winnerPlayer.scoreIncremental();
            }
        }
        return players.stream().max(Comparator.comparing(Player::getScore)).get();
    }

}
