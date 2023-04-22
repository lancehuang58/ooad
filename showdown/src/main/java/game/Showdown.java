package game;

import game.card.Card;
import game.player.AiPlayer;
import game.player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class Showdown {

    private List<Player> players;
    private Deck deck;

    public void play() {
        initPlayer();
        initDeck();
        dispatchCards();
        rounds(13);
        showWinner();
    }

    private void initPlayer() {
        this.players = new ArrayList<>();
        players.add(new AiPlayer());
        players.add(new AiPlayer());
        players.add(new AiPlayer());
        players.add(new AiPlayer());
    }

    private void initDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    private void dispatchCards() {
        while (!deck.isEmpty()) {
            for (Player player : players) {
                player.addCard(deck.drawCard());
            }
        }
    }

    private void rounds(int i) {
        for (int j = 0; j < i; j++) {
            Card winCard = null;
            Player winner = null;
            for (Player player : players) {
                List<Player> others = players.stream().filter(player1 -> player1.equals(player)).collect(Collectors.toList());
                Card card = player.takeTurn(others);
                winCard = isNull(winCard) ? card : winCard.compare(card) > 0 ? winCard : card;
                winner = isNull(winner) ? player : winCard.compare(card) > 0 ? winner : player;
            }
            winner.gainPoint();
        }
    }

    private void showWinner() {
        Player player = players.stream().max(Comparator.comparing(Player::getPoint)).get();
        System.out.printf("winner is %s , point is %d\n", player.getName(), player.getPoint());
    }

}
