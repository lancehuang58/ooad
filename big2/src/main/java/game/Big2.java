package game;

import game.card.comparator.FullHouseComparator;
import game.card.comparator.SingleComparator;
import game.card.comparator.TwoPairComparator;
import game.card.pattern.CardPattern;
import game.card.pattern.CardPatternType;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
public class Big2 {
  private final List<Player> players;
  private final Dictionary<CardPatternType, Comparator<CardPattern>> PATTERN_COMPARATORS_LOOKUP =
      new Hashtable<>();
  private CardPattern topPlay;
  private Player topPlayer;
  private Deck deck;
  private int currentIndex = -1;
  private int firstIndex = -1;

  public Big2() {
    players = new ArrayList<>();
    PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.SINGLE, new SingleComparator());
    PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.TWO_PAIR, new TwoPairComparator());
    PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.STRAIGHT, new SingleComparator());
    PATTERN_COMPARATORS_LOOKUP.put(CardPatternType.FULL_HOUSE, new FullHouseComparator());
  }

  private static boolean isPass(String input) {
    return input.equals("-1");
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

  public void takeTurn(String input) {

    if (isNull(topPlayer)) {
      topPlayer = firstPlayer();
      currentIndex = topPlayer.getIndex();
      firstIndex = topPlayer.getIndex();
    }

    if (isNewTurn()) {
      clearTopPlay();
      log.info("新的回合開始了");
      if (isPass(input)) {
        log.info("你不能在新的回合中喊 PASS");
        return;
      }
    }

    Player currentPlayer = players.get(currentIndex);

    if (isPass(input)) {
      log.info("玩家 {} PASS", currentPlayer);
      moveToNextPlayer();
      return;
    }

    log.info("輪到{}", currentPlayer.getName());
    currentPlayer.printHandCards();
    CardPattern pattern = currentPlayer.deal(input);

    if (isNull(pattern)
        || (nonNull(topPlay) && pattern.getCardPatternType() != topPlay.getCardPatternType())) {
      log.info("此牌型不合法，請再試一次");
      return;
    }

    log.info("玩家{} 打出了{}", currentPlayer.getName(), pattern);

    if (isNull(topPlay)) {
      topPlay = pattern;
      topPlayer = currentPlayer;
    } else {
      Comparator<CardPattern> comparator =
          PATTERN_COMPARATORS_LOOKUP.get(topPlay.getCardPatternType());
      boolean compareResult = comparator.compare(topPlay, pattern) > 0;
      topPlay = compareResult ? topPlay : pattern;
      topPlayer = compareResult ? topPlayer : currentPlayer;
    }

    if (currentPlayer.isWinner()) {
      log.info("遊戲結束，遊戲的勝利者為 {}", currentPlayer.getName());
      return;
    }

    moveToNextPlayer();
  }

  private void moveToNextPlayer() {
    currentIndex = (currentIndex + 1) % 4;
  }

  private boolean isNewTurn() {
    return firstIndex == currentIndex;
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
