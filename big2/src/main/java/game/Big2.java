package game;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Big2 {

    private CardPattern topPlay;

    private Player topPlayer;

    private final List<Player> players;

    private Deck deck;

    public Big2() {
        this.players = new ArrayList<>();
    }

    public void play() {
        topPlayer = firstPlayer();

    }

    public void initDeck(String input) {
        this.deck = new Deck(input);
    }

    private Player firstPlayer() {
        for (Player player : players) {
            if (player.haveC3()) {
                return player;
            }
        }
        return null;
    }

    private void takeTurns() {

    }

    private void clearTopPlay() {
        this.topPlay = null;
    }

    public void nextInput(String input) {

    }

    public void addPlayer(String name) {
        log.info("add player {}", name);
        players.add(new Player(name));
    }

    public void dispatchCard() {
        Objects.requireNonNull(deck);
        while (!deck.isEmpty()) {
            for (Player player : players) {
                player.addCard(deck.deal());
            }
        }

        for (Player player : players) {
            player.sortHandCards();
            player.printCards();
        }
    }
}
