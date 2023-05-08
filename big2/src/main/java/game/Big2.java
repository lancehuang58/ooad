package game;

import game.card.comparator.FullHouseComparator;
import game.card.comparator.SingleComparator;
import game.card.comparator.TwoPairComparator;
import game.card.pattern.CardPattern;
import game.card.pattern.CardPatternType;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Big2 {

    private CardPattern topPlay;

    private Player topPlayer;

    private final List<Player> players;

    private Deck deck;

    private int currentIndex = -1;
    private int firstIndex = -1;

    private final Dictionary<CardPatternType, Comparator<CardPattern>> PATTERN_COMPARATORS_LOOKUP = new Hashtable<>();


    public Big2() {
        this.players = new ArrayList<>();
        PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.SINGLE, new SingleComparator());
        PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.TWO_PAIR, new TwoPairComparator());
        PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.STRAIGHT, new SingleComparator());
        PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.FULL_HOUSE, new FullHouseComparator());
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
        if (gameStart()) {
            topPlayer = firstPlayer();
            currentIndex = topPlayer.getIndex();
            firstIndex = topPlayer.getIndex();
            takeTurn(topPlayer, input);
        } else {
            takeTurn(players.get(currentIndex), input);
        }
    }

    private boolean gameStart() {
        return currentIndex == -1;
    }

    private void takeTurn(Player player, String input) {
        if (isNewTurn()) {
            clearTopPlay();
            System.out.println("新的回合開始了");
            if (isPass(input)) {
                System.out.println("你不能在新的回合中喊 PASS");
                return;
            }
        }

        if (isPass(input)) {
            System.out.printf("玩家 %s PASS\n", player.getName());
            currentIndex = (currentIndex + 1) % 4;
            return;
        }

        System.out.println("輪到" + player.getName());
        player.printHandCards();
        System.out.println(player.getName() + "　輸入 " + input);
        CardPattern pattern = player.deal(input);

        if (pattern == null || (topPlay != null && pattern.getCardPatternType() != topPlay.getCardPatternType())) {
            System.out.println("此牌型不合法，請再試一次");
            return;
        }

        System.out.printf("玩家%s 打出了%s\n", player.getName(), pattern);
        if (topPlay == null) {
            topPlay = pattern;
            topPlayer = player;
        } else {
            Comparator<CardPattern> cardPatternComparator = PATTERN_COMPARATORS_LOOKUP.get(topPlay.getCardPatternType());
            boolean compareResult = cardPatternComparator.compare(topPlay, pattern) > 0;
            topPlay = compareResult ? topPlay : pattern;
            topPlayer = compareResult ? topPlayer : player;
        }

        if (player.isWinner()) {
            System.out.println("遊戲結束，遊戲的勝利者為 " + player.getName());
            return;
        }

        currentIndex = (currentIndex + 1) % 4;
    }

    private boolean isNewTurn() {
        return firstIndex == currentIndex;
    }

    private static boolean isPass(String input) {
        return input.equals("-1");
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
