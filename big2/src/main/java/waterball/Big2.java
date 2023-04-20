package waterball;

import org.apache.commons.lang3.StringUtils;
import waterball.card.*;
import waterball.player.AiPlayer;
import waterball.player.HandCard;
import waterball.player.Player;
import waterball.util.TestFileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Big2 {

    Deck deck;
    List<Player> players = new ArrayList<>(4);
    BufferedReader reader;

    public Big2() throws IOException {
        initFileReader();
        initDeck();
        initPlayer();
        dispatchCard();
    }

    private void dispatchCard() {
        while (!deck.isEmpty()) {
            for (Player player : players) {
                player.addCard(deck.dispatchCard());
            }
        }
        for (Player player : players) {
            player.sortHandCards();
        }
    }

    private void initPlayer() throws IOException {
        players.add(new AiPlayer(reader.readLine()));
        players.add(new AiPlayer(reader.readLine()));
        players.add(new AiPlayer(reader.readLine()));
        players.add(new AiPlayer(reader.readLine()));
    }

    private void initDeck() throws IOException {
        String input = reader.readLine();
        deck = new CardParser().parse(input);
    }

    public void start() throws IOException {
        int round = 1;
        int i = findFirstPlayerIndex(players);
        CardPattern topPlay = null;
        while (!winnerExist()) {
            System.out.println("新的回合開始了");
            i = i % 4;
            Player player = players.get(i);
            System.out.printf("輪到%s了\n", player.getName());
            player.printCards();
            String input = reader.readLine();
            if (StringUtils.isNotBlank(input)) {
                int[] inputValue = parseInputValues(input);
                System.out.printf("%s 輸入 %s\n", player.getName(), input);
                topPlay = player.deal(inputValue);
                System.out.println("card pattern "+topPlay);
                i++;
            } else {
                break;
            }

        }
    }

    private int[] parseInputValues(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt).mapToInt(i -> i).toArray();
    }

    private boolean winnerExist() {
        return players.stream()
                .anyMatch(player -> player.getHandCard().isEmpty());
    }

    private int findFirstPlayerIndex(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            HandCard handCard = players.get(i).getHandCard();
            Optional<Card> any = handCard.stream()
                    .filter(card -> card.getRank().getValue() == 3 &&
                            card.getSuit().equals(Suit.C)).findAny();
            if (any.isPresent()) {
                return i;
            }
        }
        return -1;
    }

    private void initFileReader() {
        InputStream inputStream = TestFileHelper.class.getResourceAsStream("/test.data");
        assert inputStream != null;
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }
}
