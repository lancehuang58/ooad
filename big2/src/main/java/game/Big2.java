package game;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        log.info("新的回合開始了。");
        topPlayer = firstPlayer();
        log.info("輪到{}了", topPlayer.getName());

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
        throw new NoSuchElementException("can't find player with C3");
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
