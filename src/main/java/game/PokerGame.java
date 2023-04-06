package game;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Slf4j
public class PokerGame implements Game {



    public Player contest(List<Player> players) {
        for (int i = 0; i < 13; i++) {
            Player winner = null;
            Card winCard = null;
            for (Player player : players) {
                Card card = player.showCard();
                log.info("player {} show card {}", player.getName(), card);
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
        for (Player player : players) {
            log.info("final score {} for player {}", player.getScore(), player.getName());
        }
        return players.stream().max(Comparator.comparing(Player::getScore)).get();
    }

    @Override
    public AbstractDeck createDeck() {
        return new PokerDeck(52);
    }


}
