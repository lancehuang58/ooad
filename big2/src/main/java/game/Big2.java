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

    private int currentIndex = -1;
    private int firstIndex = -1;

    public Big2() {
        this.players = new ArrayList<>();
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
        if (gameNotStarted()) {
            topPlayer = firstPlayer();
            currentIndex = topPlayer.getIndex();
            firstIndex = topPlayer.getIndex();
            takeTurn(topPlayer, input);
        } else {
            takeTurn(players.get(currentIndex), input);
        }
    }

    private boolean gameNotStarted() {
        return currentIndex == -1;
    }

    private void takeTurn(Player player, String input) {
        if (firstIndex == currentIndex) {
            clearTopPlay();
            System.out.println("新的回合開始了");
            if (input.equals("-1")) {
                System.out.println("你不能在新的回合中喊 PASS");
                return;
            }
        }

        if (input.equals("-1")) {
            System.out.printf("玩家 %s PASS\n", player.getName());
            currentIndex = (currentIndex + 1) % 4;
            return;
        }

        System.out.println("輪到" + player.getName());
        player.printHandCards();
        System.out.println(player.getName() + "　輸入 " + input);
        CardPattern pattern = player.deal(input);

        if (topPlay == null) {
            topPlay = pattern;
            topPlayer = player;
        } else {
            boolean compareResult = topPlay.compareTo(pattern) > 0;
            topPlay = compareResult ? topPlay : pattern;
            topPlayer = compareResult ? topPlayer : player;
        }

        if (player.isWinner()) {
            System.out.println("遊戲結束，遊戲的勝利者為 " + player.getName());
            return;
        }

        currentIndex = (currentIndex + 1) % 4;
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
        }
    }
}
